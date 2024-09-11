package com.codingfuture.erp.mapper;

import com.codingfuture.erp.dto.StoreDTO;
import com.codingfuture.erp.dto.StoreGoodsDTO;
import com.codingfuture.erp.entity.Store;
import com.codingfuture.erp.entity.StoreDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoreMapper {
    List<Store> getStoreList();

    List<StoreGoodsDTO> storeMapper(@Param("storeName") Long storeName,
                                    @Param("goodsName") Long goodsName);

    List<Store> getChangeStoreList();

    Integer getStoreDetailCount(@Param("storeName") Long storeName,
                                @Param("goodsName") Long goodsName);

    Store getStoreByUuid(Long uuid);

    //    ---------------------------------------------------------
    List<StoreDTO> findListByPage(StoreDTO storeDTO);

    Store findById(Integer id);

    boolean deleteById(Integer id);

    boolean updateById(StoreDTO storeDTO);

    boolean add(StoreDTO storeDTO);


    List<StoreDTO> findStore();

    List<StoreDetail> findStoreDetail();

    boolean minusNum(@Param("storeuuid") Long storeuuid,
                     @Param("num") Long num,
                     @Param("goodsuuid") Long goodsuuid);

    StoreDTO findByName(String name);
}
