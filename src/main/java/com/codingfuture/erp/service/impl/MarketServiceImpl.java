package com.codingfuture.erp.service.impl;

import com.codingfuture.erp.dto.GoodsTypeDTO;
import com.codingfuture.erp.dto.MarketDTO;
import com.codingfuture.erp.entity.Market;
import com.codingfuture.erp.mapper.MarketMapper;


import com.codingfuture.erp.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MarketServiceImpl implements MarketService {

    @Autowired
    private MarketMapper marketMapper;
    @Override
    public List<String> getYear() {
        Set<String> uniqueYears = new HashSet<>();
        List<String> sortedYears = new ArrayList<>();
        List<Market> markets = marketMapper.getYear();
        for (Market market : markets) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
            String year = simpleDateFormat.format(market.getCreateTime());
            if (uniqueYears.add(year)) {
                sortedYears.add(year);
            }
        }

        // 降序排序
        Collections.sort(sortedYears, Collections.reverseOrder());
        return sortedYears;
    }

    @Override
    public List<MarketDTO> getMonthByYear(Integer year) {
        return  marketMapper.getMonthList(year);
    }

    @Override
    public List<GoodsTypeDTO> getGoodsTypeList() {
        return marketMapper.getGoodsTypeList();
    }

}
