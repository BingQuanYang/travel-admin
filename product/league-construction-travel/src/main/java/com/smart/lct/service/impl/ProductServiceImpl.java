package com.smart.lct.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smart.commons.result.ResultCodeEnum;
import com.smart.commons.untils.ColaBeanUtils;
import com.smart.lct.bo.ProductBo;
import com.smart.lct.dto.ProductDto;
import com.smart.lct.entity.Product;
import com.smart.lct.entity.SortingTag;
import com.smart.lct.exception.ServiceException;
import com.smart.lct.mapper.ProductMapper;
import com.smart.lct.mapper.SortingTagMapper;
import com.smart.lct.service.ProductService;
import com.smart.lct.vo.ProductListVo;
import com.smart.lct.vo.ProductVo;
import com.smart.lct.vo.SortingTagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    ProductMapper productMapper;

    /**
     * 根据状态和类型获取指定页码的产品列表数据
     *
     * @param productDto 获取产品列表的请求参数
     * @return 产品列表
     */
    @Override
    public ProductListVo list(ProductDto productDto) {
        ProductListVo productListVo = new ProductListVo();
        try {
            //获取产品信息
            List<ProductBo> productBos = productMapper.selectPageByStatusAndType(productDto.getProductStatus(), productDto.getProductType(), (productDto.getPage() - 1) * 16);
            ArrayList<ProductVo> productVos = new ArrayList<>();
            productBos.forEach(productBo -> {
                ProductVo productVo = new ProductVo();
                BeanUtils.copyProperties(productBo, productVo);
                List<SortingTagVo> sortingTagVos = ColaBeanUtils.copyListProperties(productBo.getSortingTags(), SortingTagVo::new);
                productVo.setSortingTagVos(sortingTagVos);
                productVos.add(productVo);
            });
            productListVo.setProductVos(productVos);

            //获取全部产品总数
            productListVo.setTotle(getTotle());

            //获取上架中的产品总数
            productListVo.setInTheShelf(getTotle(1));

            //获取待下架的产品总数
            productListVo.setToBeRemoved(getTotle(2));

            //获取仓库中的产品总数
            productListVo.setCreatingALibrary(getTotle(3));

            //获取草稿箱的产品总数
            productListVo.setDrafts(getTotle(4));

            //获取回收站的产品总数
            productListVo.setRecycleBin(getTotle(5));

            //计算总页数
            long totle = getTotle(productDto.getProductStatus());
            if (totle % 16 == 0) {
                productListVo.setTotlePage(totle / 16);
            } else {
                productListVo.setTotlePage(totle / 16 + 1);
            }
        } catch (Exception e) {
            throw new ServiceException(ResultCodeEnum.ERROR);
        } finally {
            return productListVo;
        }
    }

    /**
     * 根据产品的id修改产品的状态
     *
     * @param productDto
     * @return
     */
    @Override
    @Transactional
    public boolean updateStatus(ProductDto productDto) {
        boolean flag = false;
        try {
            Optional.ofNullable(productDto).map(pd -> pd.getProductIds()).map(ids -> productDto.getProductStatus()).orElseThrow(() -> new ServiceException(ResultCodeEnum.ERROR));
            productDto.getProductIds().forEach(id -> {
                Product product = new Product();
                product.setProductStatus(productDto.getProductStatus());
                int update = productMapper.update(product, new QueryWrapper<Product>().lambda().eq(Product::getProductId, id).eq(Product::getDeleteStatus, 0));
                if (update < 1) {
                    throw new ServiceException(ResultCodeEnum.ERROR);
                }
            });
            flag = true;
        } catch (Exception e) {
            throw new ServiceException(ResultCodeEnum.ERROR);
        } finally {
            return flag;
        }

    }

    /**
     * 获取全部产品的总数
     */
    public long getTotle() {
        return productMapper.selectCount(new QueryWrapper<Product>().lambda().eq(Product::getDeleteStatus, 0));
    }

    /**
     * 获取指定状态产品的总数
     */
    public long getTotle(int status) {
        return productMapper.selectCount(new QueryWrapper<Product>().lambda().eq(Product::getProductStatus, status).eq(Product::getDeleteStatus, 0));
    }
}
