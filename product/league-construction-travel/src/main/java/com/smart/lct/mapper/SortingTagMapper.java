package com.smart.lct.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.lct.entity.SortingTag;
import org.apache.ibatis.annotations.Param;

public interface SortingTagMapper extends BaseMapper<SortingTag> {
    /**
     * 根据产品id删除所有
     *
     * @param productId
     * @return
     */
    int deleteAllByProductId(@Param("productId") long productId);
}