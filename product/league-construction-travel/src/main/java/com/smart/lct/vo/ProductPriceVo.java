package com.smart.lct.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class ProductPriceVo {
    /**
     * 主键
     */
    private Long productPriceId;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 套餐
     */
    private String setMeal;

    /**
     * 成人-价格区间
     */
    private String pricrAdult;

    /**
     * 小孩-价格区间
     */
    private String priceChild;

    /**
     * 单房差-价格区间
     */
    private String priceSingle;

    /**
     * 平日-价格区间
     */
    private String priceWeekdays;

    /**
     * 周末-价格区间
     */
    private String priceWeekend;

    /**
     * 有效期
     */
    private Date termOfValidity;

    /**
     * 是否通用价格:0->否,1->是
     */
    private Integer isCurrency;
}
