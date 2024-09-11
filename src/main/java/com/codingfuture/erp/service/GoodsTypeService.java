package com.codingfuture.erp.service;

import com.codingfuture.erp.entity.Goods;
import com.codingfuture.erp.entity.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    List<GoodsType> findListByPage(String name);

    boolean deleteById(Integer id);

    boolean updateById(GoodsType goodsType);

    boolean add(String name);

    GoodsType findById(Integer id);

    List<GoodsType> findType();

    GoodsType findByName(String name);

}
