package com.smart.lct.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 产品标签表
 */
@Data
@TableName(value = "t_sorting_tag")
public class SortingTag {
    /**
     * 主键
     */
    @TableId(value = "sorting_tag_id", type = IdType.AUTO)
    private Long sortingTagId;

    /**
     * 排序标签
     */
    @TableField(value = "sorting_tag_name")
    private String sortingTagName;

    /**
     * 产品id
     */
    @TableField(value = "product_id")
    private Long productId;

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

    public static final String COL_SORTING_TAG_ID = "sorting_tag_id";

    public static final String COL_SORTING_TAG_NAME = "sorting_tag_name";

    public static final String COL_PRODUCT_ID = "product_id";

    public static final String COL_DELETE_STATUS = "delete_status";

    public static final String COL_VERSION = "version";
}