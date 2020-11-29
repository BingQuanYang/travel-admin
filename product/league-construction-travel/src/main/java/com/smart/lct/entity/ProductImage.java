package com.smart.lct.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
    * 产品图片表
    */
@Data
@TableName(value = "t_product_image")
public class ProductImage {
    /**
     * 主键
     */
    @TableId(value = "product_image_id", type = IdType.AUTO)
    private Long productImageId;

    /**
     * 产品id
     */
    @TableField(value = "product_id")
    private Long productId;

    /**
     *  图片类型：0->景点图,1->基地图,2->banner图,3->广告图,4->其他图,5->拓展项目图,6->趣味游戏图,7->分类图
     */
    @TableField(value = "image_type")
    private Integer imageType;

    /**
     * 图片目的地
     */
    @TableField(value = "image_destination")
    private String imageDestination;

    /**
     * 图片url
     */
    @TableField(value = "image_url")
    private String imageUrl;

    /**
     * 图片名称
     */
    @TableField(value = "image_name")
    private String imageName;

    /**
     * 图片详情
     */
    @TableField(value = "image_detail")
    private String imageDetail;

    /**
     * 图片宽度
     */
    @TableField(value = "image_width")
    private Integer imageWidth;

    /**
     * 图片高度
     */
    @TableField(value = "image_height")
    private Integer imageHeight;

    /**
     * 图片排序号
     */
    @TableField(value = "image_sort")
    private Integer imageSort;

    /**
     * 图片发布人
     */
    @TableField(value = "publisher")
    private String publisher;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 上架状态：0->未上架,1->已上架
     */
    @TableField(value = "on_shelf_status")
    private Integer onShelfStatus;

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

    public static final String COL_PRODUCT_IMAGE_ID = "product_image_id";

    public static final String COL_PRODUCT_ID = "product_id";

    public static final String COL_IMAGE_TYPE = "image_type";

    public static final String COL_IMAGE_DESTINATION = "image_destination";

    public static final String COL_IMAGE_URL = "image_url";

    public static final String COL_IMAGE_NAME = "image_name";

    public static final String COL_IMAGE_DETAIL = "image_detail";

    public static final String COL_IMAGE_WIDTH = "image_width";

    public static final String COL_IMAGE_HEIGHT = "image_height";

    public static final String COL_IMAGE_SORT = "image_sort";

    public static final String COL_PUBLISHER = "publisher";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_ON_SHELF_STATUS = "on_shelf_status";

    public static final String COL_DELETE_STATUS = "delete_status";

    public static final String COL_VERSION = "version";
}