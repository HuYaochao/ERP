package com.codingfuture.erp.service;


import com.codingfuture.erp.dto.GoodsTypeDTO;
import com.codingfuture.erp.dto.MarketDTO;

import java.util.List;

public interface MarketService {

    List<String> getYear();

    List<MarketDTO> getMonthByYear(Integer year);


    List<GoodsTypeDTO> getGoodsTypeList();
}
