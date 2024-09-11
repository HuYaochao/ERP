package com.codingfuture.erp.service.impl;

import com.codingfuture.erp.entity.Storealert;
import com.codingfuture.erp.mapper.StorealertMapper;
import com.codingfuture.erp.service.StorealertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorealertServiceImpl implements StorealertService {

    @Autowired
    StorealertMapper storealertMapper;

    @Override
    public List<Storealert> getstorealert(Integer page, Integer rows) {
        return storealertMapper.getstorealert(page,rows);
    }

    @Override
    public Integer getstorealertCount(Integer page, Integer rows) {
        return storealertMapper.getstorealertCount(page,rows);
    }

}
