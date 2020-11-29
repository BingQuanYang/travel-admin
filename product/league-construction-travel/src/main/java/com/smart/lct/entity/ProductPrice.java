package com.smart.lct.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
    * 产品价格管理表
    */
@Data
@TableName(value = "t_product_price")
public class ProductPrice {
    /**
     * 主键
     */
    @TableId(value = "product_price_id", type = IdType.AUTO)
    private Long productPriceId;

    /**
     * 产品id
     */
    @TableField(value = "product_id")
    private Long productId;

    /**
     * 套餐
     */
    @TableField(value = "set_meal")
    private String setMeal;

    /**
     * 成人-价格区间
     */
    @TableField(value = "pricr_adult")
    private String pricrAdult;

    /**
     * 小孩-价格区间
     */
    @TableField(value = "price_child")
    private String priceChild;

    /**
     * 单房差-价格区间
     */
    @TableField(value = "price_single")
    private String priceSingle;

    /**
     * 平日-价格区间
     */
    @TableField(value = "price_weekdays")
    private String priceWeekdays;

    /**
     * 周末-价格区间
     */
    @TableField(value = "price_weekend")
    private String priceWeekend;

    /**
     * 有效期
     */
    @TableField(value = "term_of_validity")
    private Date termOfValidity;

    /**
     * 是否通用价格:0->否,1->是
     */
    @TableField(value = "is_currency")
    private Integer isCurrency;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 逻辑删除:0->未删除,1->已删除
     */
    @TableField(value = "delete_status")
    private Integer deleteStatus;

    /**
     * 版本号
     */
    @TableField(value = "version")
    private Long version;

    public static final String COL_PRODUCT_PRICE_ID = "product_price_id";

    public static final String COL_PRODUCT_ID = "product_id";

    public static final String COL_SET_MEAL = "set_meal";

    public static final String COL_PRICR_ADULT = "pricr_adult";

    public static final String COL_PRICE_CHILD = "price_child";

    public static final String COL_PRICE_SINGLE = "price_single";

    public static final String COL_PRICE_WEEKDAYS = "price_weekdays";

    public static final String COL_PRICE_WEEKEND = "price_weekend";

    public static final String COL_TERM_OF_VALIDITY = "term_of_validity";

    public static final String COL_IS_CURRENCY = "is_currency";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_DELETE_STATUS = "delete_status";

    public static final String COL_VERSION = "version";
}