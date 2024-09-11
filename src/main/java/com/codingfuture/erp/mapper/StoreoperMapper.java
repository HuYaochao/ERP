package com.codingfuture.erp.mapper;

import com.codingfuture.erp.dto.OperListDTO;
import com.codingfuture.erp.dto.OperQueryDTO;
import com.codingfuture.erp.entity.Storeoper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoreoperMapper {
    List<Storeoper> getStoreList();

    List<OperListDTO> getOperList(@Param("operQueryDTO") OperQueryDTO operQueryDTO);

    Integer getOperListCount(@Param("operQueryDTO") OperQueryDTO operQueryDTO);
}
