package com.codingfuture.erp.mapper;

import com.codingfuture.erp.dto.TypeGoodsDTO;
import com.codingfuture.erp.dto.GoodsSaleDTO;
import com.codingfuture.erp.entity.Goods;
import com.codingfuture.erp.entity.GoodsType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<Goods> getGoodsList();

    List<Goods> getChangeGoodsList();

    //    -----------------------------------------------------
    List<TypeGoodsDTO> findListByPage(TypeGoodsDTO typeGoodsDTO);

    boolean deleteById(Integer id);

    TypeGoodsDTO findById(Integer id);

    boolean add(TypeGoodsDTO typeGoodsDTO);

    boolean updateById(TypeGoodsDTO typeGoodsDTO);

    List<GoodsSaleDTO> findAllGoods();

    GoodsType findByName(String name);

    List<Goods> check(Long foreignKeyId);
}