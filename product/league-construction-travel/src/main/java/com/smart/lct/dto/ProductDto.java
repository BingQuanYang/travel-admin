package com.smart.lct.dto;

import lombok.Data;
import lombok.Value;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class ProductDto {
    //产品状态
//    @Size(min = 0, max = 5)
    int productStatus;

    //产品类型
//    @Size(min = 0, max = 4)
    int productType;
    //页码数
//    @Min(0)
    int page;
    //产品id
    List<Long> productIds;
}
