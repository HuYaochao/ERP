package com.codingfuture.erp.service.impl;

import com.codingfuture.erp.dto.OperListDTO;
import com.codingfuture.erp.dto.OperQueryDTO;
import com.codingfuture.erp.entity.Storeoper;
import com.codingfuture.erp.mapper.StoreoperMapper;
import com.codingfuture.erp.service.StoreoperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreoperServiceImpl implements StoreoperService {

    @Autowired
    private StoreoperMapper storeoperMapper;

    @Override
    public List<Storeoper> getStoreList() {

        return storeoperMapper.getStoreList();
    }

    @Override
    public List<OperListDTO> getOperList(OperQueryDTO operQueryDTO) {

        return storeoperMapper.getOperList(operQueryDTO);
    }

    @Override
    public Integer getOperListCount(OperQueryDTO operQueryDTO) {
        return storeoperMapper.getOperListCount(operQueryDTO);

    }
}
