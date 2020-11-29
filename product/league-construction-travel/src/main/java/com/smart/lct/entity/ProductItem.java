package com.smart.lct.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 产品详情表
 */
@Data
@TableName(value = "t_product_item")
public class ProductItem {
    /**
     * 主键
     */
    @TableId(value = "product_item_id", type = IdType.AUTO)
    private Long productItemId;

    /**
     * 产品编号
     */
    @TableField(value = "product_number")
    private String productNumber;

    /**
     * 产品id
     */
    @TableField(value = "product_id")
    private Long productId;

    /**
     * 产品负责人
     */
    @TableField(value = "product_person")
    private String productPerson;

    /**
     * 分数
     */
    @TableField(value = "score")
    private Integer score;

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
     * 特色
     */
    @TableField(value = "product_features")
    private String productFeatures;

    /**
     * 出发地
     */
    @TableField(value = "place_of_departure")
    private String placeOfDeparture;

    /**
     * 目的地
     */
    @TableField(value = "destination")
    private String destination;

    /**
     * 产品类型：1->拓展团建,2->团建旅游,3->常规旅游,4->奖励旅游
     */
    @TableField(value = "product_type")
    private Integer productType;

    /**
     * 主题:0->海边沙滩,1->户外徒步,2->野战CS,3->划皮船
     */
    @TableField(value = "theme")
    private Integer theme;

    /**
     * 去程交通工具
     */
    @TableField(value = "go_vehicle")
    private String goVehicle;

    /**
     * 返程交通工具
     */
    @TableField(value = "go_back_vehicle")
    private String goBackVehicle;

    /**
     * 行程天数
     */
    @TableField(value = "day")
    private Integer day;

    /**
     * 行程晚数
     */
    @TableField(value = "night")
    private Integer night;

    /**
     * 详情图
     */
    @TableField(value = "detailed_drawing")
    private String detailedDrawing;

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

    public static final String COL_PRODUCT_ITEM_ID = "product_item_id";

    public static final String COL_PRODUCT_NUMBER = "product_number";

    public static final String COL_PRODUCT_ID = "product_id";

    public static final String COL_PRODUCT_PERSON = "product_person";

    public static final String COL_SCORE = "score";

    public static final String COL_MAIN_HEADING = "main_heading";

    public static final String COL_SUBHEADING = "subheading";

    public static final String COL_PRODUCT_FEATURES = "product_features";

    public static final String COL_PLACE_OF_DEPARTURE = "place_of_departure";

    public static final String COL_DESTINATION = "destination";

    public static final String COL_PRODUCT_TYPE = "product_type";

    public static final String COL_THEME = "theme";

    public static final String COL_GO_VEHICLE = "go_vehicle";

    public static final String COL_GO_BACK_VEHICLE = "go_back_vehicle";

    public static final String COL_DAY = "day";

    public static final String COL_NIGHT = "night";

    public static final String COL_DETAILED_DRAWING = "detailed_drawing";

    public static final String COL_DELETE_STATUS = "delete_status";

    public static final String COL_VERSION = "version";
}