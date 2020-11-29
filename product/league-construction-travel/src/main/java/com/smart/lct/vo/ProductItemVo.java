package com.smart.lct.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

@Data
public class ProductItemVo {
    /**
     * 主键
     */
    private Long productItemId;

    /**
     * 产品编号
     */
    private String productNumber;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 产品负责人
     */
    private String productPerson;

    /**
     * 分数
     */
    private Integer score;

    /**
     * 主标题
     */
    private String ainHeading;

    /**
     * 副标题
     */
    private String subheading;

    /**
     * 特色
     */
    private String productFeatures;

    /**
     * 出发地
     */
    private String placeOfDeparture;

    /**
     * 目的地
     */
    private String destination;

    /**
     * 产品类型：1->拓展团建,2->团建旅游,3->常规旅游,4->奖励旅游
     */
    private Integer productType;

    /**
     * 主题:0->海边沙滩,1->户外徒步,2->野战CS,3->划皮船
     */
    private Integer theme;

    /**
     * 去程交通工具
     */
    private String goVehicle;

    /**
     * 返程交通工具
     */
    private String goBackVehicle;

    /**
     * 行程天数
     */
    private Integer day;

    /**
     * 行程晚数
     */
    private Integer night;

    /**
     * 详情图
     */
    private String detailedDrawing;

    /**
     * 产品信息
     */
    private ProductVo productVo;

    /**
     * 产品图片信息
     */
    private List<ProductImageVo> productImageVos;

    /**
     * 产品图片信息
     */
    private List<ProductPriceVo> productPriceVos;
}
