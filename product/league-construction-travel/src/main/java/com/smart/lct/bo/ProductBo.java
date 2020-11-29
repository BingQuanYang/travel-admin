package com.smart.lct.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.smart.lct.entity.SortingTag;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class ProductBo {
    /**
     * 主键
     */
    private Long productId;

    /**
     * 产品编号
     */
    private String productNumber;

    /**
     * 产品状态：1->上架中,2->待上架,3->仓库中,4->草稿箱,5->回收站
     */
    private Integer productStatus;

    /**
     * 产品类型：1->拓展团建,2->团建旅游,3->常规旅游,4->奖励旅游
     */
    private Integer productType;

    /**
     * 主要景点
     */
    private String mainTouristAttraction;

    /**
     * 主标题
     */
    private String mainHeading;

    /**
     * 副标题
     */
    private String subheading;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 过期时间
     */
    private Date expirationTime;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 更新人
     */
    private String updatePerson;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 分数
     */
    private Integer score;

    /**
     * 点击数量
     */
    private Long click;

    /**
     * 逻辑删除:0->未删除,1->已删除
     */
    private Integer deleteStatus;

    /**
     * 版本号
     */
    private Long version;

    /**
     * 排序标签
     */
    private List<SortingTag> sortingTags;
}
