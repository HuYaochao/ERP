package com.codingfuture.erp.service.impl;

import com.codingfuture.erp.dto.TypeGoodsDTO;
import com.codingfuture.erp.dto.GoodsSaleDTO;
import com.codingfuture.erp.entity.Goods;
import com.codingfuture.erp.entity.GoodsType;
import com.codingfuture.erp.mapper.GoodsMapper;
import com.codingfuture.erp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getGoodsList() {
        return goodsMapper.getGoodsList();

    }

    @Override
    public List<Goods> getChangeGoodsList() {
        return goodsMapper.getChangeGoodsList();
    }

//    --------------------------------------------------------------

    @Override
    public List<TypeGoodsDTO> findListByPage(TypeGoodsDTO typeGoodsDTO) {
        return goodsMapper.findListByPage(typeGoodsDTO);
    }

    public boolean deleteById(Integer id) {
        return goodsMapper.deleteById(id);
    }

    @Override
    public boolean updateById(TypeGoodsDTO typeGoodsDTO) {
        return goodsMapper.updateById(typeGoodsDTO);
    }

    @Override
    public boolean add(TypeGoodsDTO typeGoodsDTO) {
        return goodsMapper.add(typeGoodsDTO);
    }

    @Override
    public TypeGoodsDTO findById(Integer id) {
        return goodsMapper.findById(id);
    }

    @Override
    public List<GoodsSaleDTO> findAllGoods() {
        return goodsMapper.findAllGoods();
    }

    @Override
    public GoodsType findByName(String name) {
        return goodsMapper.findByName(name);
    }

    @Override
    public List<Goods> check(Long foreignKeyId) {
        return goodsMapper.check(foreignKeyId);
    }

}
