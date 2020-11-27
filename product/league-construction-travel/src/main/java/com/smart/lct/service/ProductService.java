package com.smart.lct.service;

import com.smart.lct.dto.ProductDto;
import com.smart.lct.entity.Product;
import com.smart.lct.vo.ProductListVo;
import com.smart.lct.vo.ProductVo;
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
}
