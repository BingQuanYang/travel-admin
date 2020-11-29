package com.smart.lct.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.lct.bo.ProductBo;
import com.smart.lct.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper extends BaseMapper<Product> {
    /**
     * 根据状态和类型页面查询一页数据
     *
     * @param productStatus 产品状态
     * @param productType   产品类型
     * @param start         查询开始位置
     * @return
     */
    List<ProductBo> selectPageByStatusAndType(@Param("productStatus") int productStatus, @Param("productType") int productType, @Param("start") int start);

    /**
     * 根据添加查
     *
     * @param search
     * @return
     */
    List<ProductBo> selectByLike(@Param("search") String search, @Param("start") int start);

    /**
     * 根据产品id查询产品信息
     *
     * @param productId 产品id
     * @return
     */
    ProductBo selectByProductId(@Param("productId") long productId);
}