package com.codingfuture.erp.service.impl;

import com.codingfuture.erp.dto.StoreDTO;
import com.codingfuture.erp.dto.StoreGoodsDTO;
import com.codingfuture.erp.entity.Store;
import com.codingfuture.erp.entity.StoreDetail;
import com.codingfuture.erp.mapper.StoreMapper;
import com.codingfuture.erp.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreMapper storeMapper;

    @Override
    public List<Store> getStoreList() {
        return storeMapper.getStoreList();
    }

    @Override
    public List<StoreGoodsDTO> getStoreDetail(Long storeName, Long goodsName) {
        return storeMapper.storeMapper(storeName, goodsName);
    }

    @Override
    public List<Store> getChangeStoreList() {
        return storeMapper.getChangeStoreList();
    }

    @Override
    public Integer getStoreDetailCount(Long storeName, Long goodsName) {
        return storeMapper.getStoreDetailCount(storeName, goodsName);
    }


    @Override
    public Store getStoreByUuid(Long uuid) {
        return storeMapper.getStoreByUuid(uuid);
    }

//    ------------------------------------------------------------------------

    @Override
    public List<StoreDTO> findListByPage(StoreDTO storeDTO) {
        return storeMapper.findListByPage(storeDTO);
    }

    @Override
    public Store findById(Integer id) {
        return storeMapper.findById(id);
    }

    @Override
    public boolean deleteById(Integer id) {
        return storeMapper.deleteById(id);
    }

    @Override
    public boolean updateById(StoreDTO storeDTO) {
        return storeMapper.updateById(storeDTO);
    }

    @Override
    public boolean add(StoreDTO storeDTO) {
        return storeMapper.add(storeDTO);
    }

    @Override
    public List<StoreDTO> findStore() {
        return storeMapper.findStore();
    }

    @Override
    public List<StoreDetail> findStoreDetail() {
        return storeMapper.findStoreDetail();
    }

    @Override
    public boolean minusNum(Long storeuuid, Long num, Long goodsuuid) {
        return storeMapper.minusNum(storeuuid, num, goodsuuid);
    }

    @Override
    public StoreDTO findByName(String name) {
        return storeMapper.findByName(name);
    }

}
