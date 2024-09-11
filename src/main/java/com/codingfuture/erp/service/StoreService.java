package com.codingfuture.erp.service;

import com.codingfuture.erp.dto.StoreGoodsDTO;
import com.codingfuture.erp.dto.StoreDTO;
import com.codingfuture.erp.entity.Store;
import com.codingfuture.erp.entity.StoreDetail;

import java.util.List;

public interface StoreService {

    List<Store> getStoreList();

    List<StoreGoodsDTO> getStoreDetail(Long storeName, Long goodsName);

    List<Store> getChangeStoreList();

    Integer getStoreDetailCount(Long storeName, Long goodsName);

    Store getStoreByUuid(Long uuid);
//    -------------------------------------------------------------------------------------------

    List<StoreDTO> findListByPage(StoreDTO storeDTO);

    Store findById(Integer id);

    boolean deleteById(Integer id);

    boolean updateById(StoreDTO storeDTO);

    boolean add(StoreDTO storeDTO);

    List<StoreDTO> findStore();

    List<StoreDetail> findStoreDetail();

    boolean minusNum(Long storeuuid, Long num,Long goodsuuid);

    StoreDTO findByName(String name);
}
