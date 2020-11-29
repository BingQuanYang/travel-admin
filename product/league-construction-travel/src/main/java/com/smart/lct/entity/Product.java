package com.smart.lct.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 产品表
 */
@Data
@TableName(value = "t_product")
public class Product {
    /**
     * 主键
     */
    @TableId(value = "product_id", type = IdType.AUTO)
    private Long productId;

    /**
     * 产品编号
     */
    @TableField(value = "product_number")
    private String productNumber;

    /**
     * 产品状态：1->上架中,2->待上架,3->仓库中,4->草稿箱,5->回收站
     */
    @TableField(value = "product_status")
    private Integer productStatus;

    /**
     * 产品类型：1->拓展团建,2->团建旅游,3->常规旅游,4->奖励旅游
     */
    @TableField(value = "product_type")
    private Integer productType;

    /**
     * 主要景点
     */
    @TableField(value = "main_tourist_attraction")
    private String mainTouristAttraction;

    /**
     * 主标题
     */
    @TableField(value = "main_heading")
    private String mainHeading;

    /**
     * 副标题
     */
    @TableField(value = "subheading")
    private String subheading;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 过期时间
     */
    @TableField(value = "expiration_time")
    private Date expirationTime;

    /**
     * 价格
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 更新人
     */
    @TableField(value = "update_person")
    private String updatePerson;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 分数
     */
    @TableField(value = "score")
    private Integer score;

    /**
     * 点击数量
     */
    @TableField(value = "click")
    private Long click;

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

    public static final String COL_PRODUCT_ID = "product_id";

    public static final String COL_PRODUCT_NUMBER = "product_number";

    public static final String COL_PRODUCT_STATUS = "product_status";

    public static final String COL_PRODUCT_TYPE = "product_type";

    public static final String COL_MAIN_TOURIST_ATTRACTION = "main_tourist_attraction";

    public static final String COL_MAIN_HEADING = "main_heading";

    public static final String COL_SUBHEADING = "subheading";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_EXPIRATION_TIME = "expiration_time";

    public static final String COL_PRICE = "price";

    public static final String COL_UPDATE_PERSON = "update_person";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_SCORE = "score";

    public static final String COL_CLICK = "click";

    public static final String COL_DELETE_STATUS = "delete_status";

    public static final String COL_VERSION = "version";
}