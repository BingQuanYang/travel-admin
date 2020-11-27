package com.smart.lct.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SortingTagVo {
    /**
     * 主键
     */
    private Long sortingTagId;

    /**
     * 排序标签
     */
    private String sortingTagName;

    /**
     * 产品id
     */
    private Long productId;
}
