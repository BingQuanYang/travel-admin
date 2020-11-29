package com.smart.lct.controller;

import com.smart.commons.result.BaseResult;
import com.smart.lct.dto.ProductDto;
import com.smart.lct.dto.ProductImageDto;
import com.smart.lct.dto.ProductItemDto;
import com.smart.lct.entity.Product;
import com.smart.lct.service.ProductService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    ProductService productService;

    /**
     * 根据产品的状态和类型获取产品的一页信息
     *
     * @param productDto
     * @return
     */
    @PostMapping("/list")
    public BaseResult list(@RequestBody @Validated ProductDto productDto) {
        return BaseResult.success(productService.list(productDto));
    }

    /**
     * 修改产品的状态
     *
     * @param productDto
     * @return
     */
    @PostMapping("/updateStatus")
    public BaseResult updateStatus(@RequestBody @Validated ProductDto productDto) {
        return BaseResult.success(productService.updateStatus(productDto));
    }

    /***
     * 根据条件查询产品信息
     * @param search
     * @param page
     * @return
     */
    @GetMapping("/search")
    public BaseResult search(String search, int page) {
        return BaseResult.success(productService.search(search, page));
    }

    /**
     * 根据产品id 获取产品的详情信息
     *
     * @param productId
     * @return
     */
    @GetMapping("/details")
    public BaseResult details(long productId) {
        return BaseResult.success(productService.details(productId));
    }

    /**
     * 添加产品详情信息
     *
     * @param productItemDto
     * @return
     */
    @PostMapping("/add")
    public BaseResult add(@RequestBody ProductItemDto productItemDto) {
        return BaseResult.success(productService.add(productItemDto));
    }

    /**
     * @param productItemDto
     * @return
     */
    @PostMapping("/update")
    public BaseResult update(@RequestBody ProductItemDto productItemDto) {
        return BaseResult.success(productService.update(productItemDto));
    }

    /**
     * 编辑图片
     *
     * @param productImageDto
     * @return
     */
    @PostMapping("/updateImage")
    public BaseResult updateImage(@RequestBody ProductImageDto productImageDto) {
        return BaseResult.success(productService.updateImage(productImageDto));
    }

}
