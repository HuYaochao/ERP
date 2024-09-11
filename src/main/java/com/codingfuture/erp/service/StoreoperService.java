package com.codingfuture.erp.service;

import com.codingfuture.erp.dto.OperListDTO;
import com.codingfuture.erp.dto.OperQueryDTO;
import com.codingfuture.erp.entity.Storeoper;

import java.util.List;

public interface StoreoperService {
    List<Storeoper> getStoreList();

    List<OperListDTO> getOperList(OperQueryDTO operQueryDTO);

    Integer getOperListCount(OperQueryDTO operQueryDTO);
}
