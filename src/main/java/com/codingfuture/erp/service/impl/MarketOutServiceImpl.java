package com.codingfuture.erp.service.impl;

import com.codingfuture.erp.mapper.MarketOutMapper;
import com.codingfuture.erp.service.MarketOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class MarketOutServiceImpl implements MarketOutService {
    @Autowired
    private MarketOutMapper marketOutMapper;

    @Override
    public boolean doOutStore(Long uuid, Long storeuuid) {
        return marketOutMapper.doOutStore(uuid, storeuuid);
    }

    @Override
    public boolean doStart(Long id, String name, Date date) {
        return marketOutMapper.doStart(id, name,date);
    }


}
