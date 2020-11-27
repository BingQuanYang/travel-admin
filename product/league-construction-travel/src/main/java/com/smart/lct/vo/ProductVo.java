package com.smart.lct.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class ProductVo {
    /**
     * 主键
     */
    private Long productId;

    /**
     * 状态：0->上架中,1->待上架,2->仓库中,3->草稿箱,4->回收站
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
     * 排序标签
     */
    List<SortingTagVo> sortingTagVos;
}
