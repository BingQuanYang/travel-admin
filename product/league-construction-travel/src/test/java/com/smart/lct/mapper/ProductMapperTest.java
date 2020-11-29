package com.smart.lct.mapper;

import com.smart.lct.bo.ProductBo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductMapperTest {
    @Resource
    ProductMapper productMapper;

    @Test
    void selectByLike() {
        List<ProductBo> bos = productMapper.selectByLike("水", 0);
        System.out.println(bos);
    }
}