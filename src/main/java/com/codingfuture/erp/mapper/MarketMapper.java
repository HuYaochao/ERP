package com.codingfuture.erp.mapper;

import com.codingfuture.erp.dto.GoodsTypeDTO;
import com.codingfuture.erp.dto.MarketDTO;
import com.codingfuture.erp.entity.Market;

import java.util.List;

public interface MarketMapper {
    List<Market> getYear();

    List<MarketDTO> getMonthList(Integer year);

    List<GoodsTypeDTO> getGoodsTypeList();
}
