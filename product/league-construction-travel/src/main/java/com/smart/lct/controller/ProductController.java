package com.smart.lct.controller;

import com.smart.commons.result.BaseResult;
import com.smart.lct.dto.ProductDto;
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

    @PostMapping("/list")
    public BaseResult list(@RequestBody @Validated ProductDto productDto) {
        return BaseResult.success(productService.list(productDto));
    }

    @PostMapping("/updateStatus")
    public BaseResult updateStatus(@RequestBody @Validated ProductDto productDto) {
        return BaseResult.success(productService.updateStatus(productDto));
    }

}
