package com.smart.lct.dto;

import lombok.Data;

@Data
public class ProductImageDto {
    /**
     * 主键
     */
    private Long productImageId;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 图片类型：0->景点图,1->基地图,2->banner图,3->广告图,4->其他图,5->拓展项目图,6->趣味游戏图,7->分类图
     */
    private Integer imageType;

    /**
     * 图片目的地
     */
    private String imageDestination;

    /**
     * 图片url
     */
    private String imageUrl;

    /**
     * 图片名称
     */
    private String imageName;

    /**
     * 图片详情
     */
    private String imageDetail;

    /**
     * 图片宽度
     */
    private Integer imageWidth;

    /**
     * 图片高度
     */
    private Integer imageHeight;

    /**
     * 图片排序号
     */
    private Integer imageSort;

    /**
     * 图片发布人
     */
    private String publisher;

    /**
     * 上架状态：0->未上架,1->已上架
     */
    private Integer onShelfStatus;
}
