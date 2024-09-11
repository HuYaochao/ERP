package com.codingfuture.erp.service.impl;

import com.codingfuture.erp.entity.Goods;
import com.codingfuture.erp.entity.GoodsType;
import com.codingfuture.erp.mapper.GoodsTypeMapper;
import com.codingfuture.erp.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {
    @Autowired
    private GoodsTypeMapper goodsTypeMapper;

    @Override
    public List<GoodsType> findListByPage(String name) {
        return goodsTypeMapper.findListByPage(name);
    }

    @Override
    public boolean deleteById(Integer id) {
        return goodsTypeMapper.deleteById(id);
    }

    @Override
    public boolean updateById(GoodsType goodsType) {
        return goodsTypeMapper.updateById(goodsType);
    }

    @Override
    public boolean add(String name) {
        return goodsTypeMapper.add(name);
    }

    @Override
    public GoodsType findById(Integer id) {
        return goodsTypeMapper.findById(id);
    }

    @Override
    public List<GoodsType> findType() {
        return goodsTypeMapper.findType();
    }

    @Override
    public GoodsType findByName(String name) {
        return goodsTypeMapper.findByName(name);
    }



}
