package com.codingfuture.erp.service;

import com.codingfuture.erp.dto.GoodsSaleDTO;
import com.codingfuture.erp.dto.MarketAddDTO;

import java.util.List;

public interface MarketAddService {
    List<MarketAddDTO> findListByPage(String state);

    List<GoodsSaleDTO> findGoodsSale(Long marketUuid);

    boolean addMarketDetail(GoodsSaleDTO goodsSaleDTO);

    boolean addMarket(MarketAddDTO marketAddDTO);

}
