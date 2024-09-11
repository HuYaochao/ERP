package com.codingfuture.erp.mapper;

import com.codingfuture.erp.entity.Goods;
import com.codingfuture.erp.entity.GoodsType;

import java.util.List;

public interface GoodsTypeMapper {
    List<GoodsType> findListByPage(String name);

    boolean deleteById(Integer id);

    boolean updateById(GoodsType goodsType);

    boolean add(String name);

    GoodsType findById(Integer id);

    List<GoodsType> findType();

    GoodsType findByName(String name);


}
