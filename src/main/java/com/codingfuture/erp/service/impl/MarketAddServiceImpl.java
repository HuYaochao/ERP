package com.codingfuture.erp.service.impl;

import com.codingfuture.erp.dto.GoodsSaleDTO;
import com.codingfuture.erp.dto.MarketAddDTO;
import com.codingfuture.erp.mapper.MarketAddMapper;
import com.codingfuture.erp.service.MarketAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketAddServiceImpl implements MarketAddService {
    @Autowired
    MarketAddMapper marketAddMapper;

    @Override
    public List<MarketAddDTO> findListByPage(String state) {
        return marketAddMapper.findListByPage(state);
    }

    @Override
    public List<GoodsSaleDTO> findGoodsSale(Long marketUuid) {
        return marketAddMapper.findGoodsSale(marketUuid);
    }

    @Override
    public boolean addMarketDetail(GoodsSaleDTO goodsSaleDTO) {
        return marketAddMapper.addMarketDetail(goodsSaleDTO);
    }

    @Override
    public boolean addMarket(MarketAddDTO marketAddDTO) {
        return marketAddMapper.addMarket(marketAddDTO);
    }


}
