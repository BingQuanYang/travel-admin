package com.smart.lct.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smart.commons.result.ResultCodeEnum;
import com.smart.commons.untils.ColaBeanUtils;
import com.smart.lct.bo.ProductBo;
import com.smart.lct.dto.ProductDto;
import com.smart.lct.dto.ProductImageDto;
import com.smart.lct.dto.ProductItemDto;
import com.smart.lct.entity.*;
import com.smart.lct.exception.ServiceException;
import com.smart.lct.mapper.*;
import com.smart.lct.service.ProductService;
import com.smart.lct.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    //产品表
    @Resource
    ProductMapper productMapper;
    //产品详情表
    @Resource
    ProductItemMapper productItemMapper;
    //排序标签表
    @Resource
    SortingTagMapper sortingTagMapper;
    //产品图片表
    @Resource
    ProductImageMapper productImageMapper;
    //产品价格管理表
    @Resource
    ProductPriceMapper productPriceMapper;

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
            //如果请求参数为null就抛异常
            Optional.ofNullable(productDto).map(pd -> pd.getProductIds()).map(ids -> productDto.getProductStatus()).orElseThrow(() -> new ServiceException(ResultCodeEnum.ERROR));
            //修改产品的状态
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
     * 根据关键词搜索产品
     *
     * @param search 关键词
     * @return
     */
    @Override
    public ProductListVo search(String search, int page) {
        ProductListVo productListVo = new ProductListVo();
        try {
            //获取产品信息
            List<ProductBo> productBos = productMapper.selectByLike(search, (page - 1) * 16);
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
            long totle = productMapper.selectCount(
                    new QueryWrapper<Product>().lambda()
                            .eq(Product::getDeleteStatus, 0).
                            like(Product::getMainTouristAttraction, search)
                            .or().like(Product::getMainHeading, search)
                            .or().like(Product::getSubheading, search)
                            .or().like(Product::getProductNumber, search)
                            .or().like(Product::getUpdatePerson, search)
            );
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
     * 根据产品id查询产品详细信息
     *
     * @param productId 产品id
     * @return
     */
    @Override
    public ProductItemVo details(long productId) {
        ProductItemVo productItemVo = new ProductItemVo();
        try {
            //获取产品信息
            ProductVo productVo = new ProductVo();
            ProductBo productBo = productMapper.selectByProductId(productId);
            BeanUtils.copyProperties(productBo, productVo);
            List<SortingTagVo> sortingTagVos = ColaBeanUtils.copyListProperties(productBo.getSortingTags(), SortingTagVo::new);
            productVo.setSortingTagVos(sortingTagVos);
            //获取产品详情信息
            ProductItem productItem = productItemMapper.selectOne(new QueryWrapper<ProductItem>().lambda().eq(ProductItem::getProductId, productId).eq(ProductItem::getDeleteStatus, 0));
            BeanUtils.copyProperties(productItem, productItemVo);
            productItemVo.setProductVo(productVo);
            //获取产品图片信息
            List<ProductImage> productImages = productImageMapper.selectList(new QueryWrapper<ProductImage>().lambda().eq(ProductImage::getProductId, productId));
            List<ProductImageVo> productImageVos = ColaBeanUtils.copyListProperties(productImages, ProductImageVo::new);
            productItemVo.setProductImageVos(productImageVos);
            //获取产品途径价格管理信息
            List<ProductPrice> productPrices = productPriceMapper.selectList(new QueryWrapper<ProductPrice>().lambda().eq(ProductPrice::getProductId, productId));
            List<ProductPriceVo> productPriceVos = ColaBeanUtils.copyListProperties(productPrices, ProductPriceVo::new);
            productItemVo.setProductPriceVos(productPriceVos);
        } catch (Exception e) {
            throw new ServiceException(ResultCodeEnum.ERROR);
        } finally {
            return productItemVo;
        }

    }

    /**
     * 添加产品信息
     *
     * @param productItemDto
     * @return
     */
    @Transactional
    @Override
    public boolean add(ProductItemDto productItemDto) {
        boolean flag = false;
        try {
            //设置产品编号
            productItemDto.setProductNumber(UUID.randomUUID().toString());
            Product product = new Product();
            ProductItem productItem = new ProductItem();
            BeanUtils.copyProperties(productItemDto, product);
            BeanUtils.copyProperties(productItemDto, productItem);
            //添加商品信息
            int i1 = productMapper.insert(product);
            productItem.setProductId(product.getProductId());
            //添加产品详情信息
            int i2 = productItemMapper.insert(productItem);
            if (i1 < 1 || i2 < 1) {
                throw new ServiceException(ResultCodeEnum.ERROR);
            }
            //判断是否有产品属性（标签排序），有则添加到标签排序表中
            Optional.ofNullable(productItemDto.getProductAttributes()).ifPresent(attr -> {
                attr.forEach(name -> {
                    SortingTag tag = new SortingTag();
                    tag.setSortingTagName(name);
                    tag.setProductId(product.getProductId());
                    sortingTagMapper.insert(tag);
                });
            });
            flag = true;
        } catch (Exception e) {
            throw new ServiceException(ResultCodeEnum.ERROR);
        } finally {
            return flag;
        }

    }

    /**
     * 修改产品信息
     *
     * @param productItemDto
     * @return
     */
    @Override
    public boolean update(ProductItemDto productItemDto) {
        boolean flag = false;
        try {
            Product product = new Product();
            ProductItem productItem = new ProductItem();
            BeanUtils.copyProperties(productItemDto, product);
            BeanUtils.copyProperties(productItemDto, productItem);
            //修改产品信息
            int i1 = productMapper.update(product, new QueryWrapper<Product>().lambda().eq(Product::getProductId, product.getProductId()));
            //修改产品详情信息
            int i2 = productItemMapper.update(productItem, new QueryWrapper<ProductItem>().lambda().eq(ProductItem::getProductId, productItem.getProductId()));
            if (i1 < 1 || i2 < 1) {
                throw new ServiceException(ResultCodeEnum.ERROR);
            }
            //修改产品属性 排序便签
            Optional.ofNullable(productItemDto.getProductAttributes()).ifPresent(attr -> {
                int i = sortingTagMapper.deleteAllByProductId(product.getProductId());
                if (i < 1) return;
                attr.forEach(name -> {
                    SortingTag tag = new SortingTag();
                    tag.setSortingTagName(name);
                    tag.setProductId(product.getProductId());
                    sortingTagMapper.insert(tag);
                });
            });
            flag = true;
        } catch (Exception e) {
            throw new ServiceException(ResultCodeEnum.ERROR);
        }
        return flag;
    }

    @Override
    public boolean updateImage(ProductImageDto productImageDto) {
        boolean flag = false;
        try {
            ProductImage productImage = new ProductImage();
            BeanUtils.copyProperties(productImageDto, productImage);
            int update = productImageMapper.update(productImage, new QueryWrapper<ProductImage>().lambda().eq(ProductImage::getProductId, productImage.getProductId()).eq(ProductImage::getProductImageId, productImage.getProductImageId()));
            if (update < 1) {
                throw new ServiceException(ResultCodeEnum.ERROR);
            }
            flag = true;
        } catch (Exception e) {
            throw new ServiceException(ResultCodeEnum.ERROR);
        }
        return flag;
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
