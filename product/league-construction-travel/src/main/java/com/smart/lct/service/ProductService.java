package com.smart.lct.service;

import com.smart.lct.dto.ProductDto;
import com.smart.lct.dto.ProductImageDto;
import com.smart.lct.dto.ProductItemDto;
import com.smart.lct.entity.Product;
import com.smart.lct.vo.ProductItemVo;
import com.smart.lct.vo.ProductListVo;
import com.smart.lct.vo.ProductVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductService {
    /**
     * 根据状态和类型获取指定页码的产品列表数据
     *
     * @param productDto 获取产品列表的请求参数
     * @return 产品列表
     */
    ProductListVo list(ProductDto productDto);

    /**
     * 根据产品的id修改产品的状态
     *
     * @param productDto
     * @return
     */
    boolean updateStatus(ProductDto productDto);

    /**
     * 根据关键词搜索产品
     *
     * @param search 关键词
     * @return
     */
    ProductListVo search(String search, int page);

    /**
     * 根据产品id查询产品详细信息
     *
     * @param productId 产品id
     * @return
     */
    ProductItemVo details(long productId);

    /**
     * 添加产品信息
     *
     * @return
     */
    boolean add(ProductItemDto productItemDto);

    /**
     * 修改产品信息
     *
     * @param productItemDto
     * @return
     */
    boolean update(ProductItemDto productItemDto);

    /**
     * 修改产品图片信息
     *
     * @param productImageDto
     * @return
     */
    boolean updateImage(ProductImageDto productImageDto);
}
