package com.codingfuture.erp.service;

import com.codingfuture.erp.dto.TypeGoodsDTO;
import com.codingfuture.erp.dto.GoodsSaleDTO;
import com.codingfuture.erp.entity.Goods;
import com.codingfuture.erp.entity.GoodsType;

import java.util.List;

public interface GoodsService {
    List<Goods> getGoodsList();

    List<Goods> getChangeGoodsList();
//--------------------------------------------------

    List<TypeGoodsDTO> findListByPage(TypeGoodsDTO typeGoodsDTO);

    boolean deleteById(Integer id);

    boolean updateById(TypeGoodsDTO typeGoodsDTO);

    boolean add(TypeGoodsDTO typeGoodsDTO);

    TypeGoodsDTO findById(Integer id);

    List<GoodsSaleDTO> findAllGoods();

    GoodsType findByName(String name);

    List<Goods> check(Long foreignKeyId);
}
