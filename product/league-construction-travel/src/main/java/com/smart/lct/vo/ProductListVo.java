package com.smart.lct.vo;

import com.smart.lct.entity.Product;
import lombok.Data;

import java.util.List;

/**
 * 产品列表页面的Vo对象
 */
@Data
public class ProductListVo {
    /**
     * 产品
     */
    List<ProductVo> productVos;
    long totle;

    /**
     * 上架中总数
     */
    long inTheShelf;

    /**
     * 待下架总数
     */
    long toBeRemoved;

    /**
     * 仓库中总数
     */
    long creatingALibrary;

    /**
     * 草稿箱总数
     */
    long drafts;

    /**
     * 回收站总数
     */
    long recycleBin;

    /**
     * 总页数
     */
    long totlePage;
}
