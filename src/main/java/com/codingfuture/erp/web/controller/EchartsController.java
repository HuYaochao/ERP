package com.codingfuture.erp.web.controller;


import com.codingfuture.erp.dto.GoodsTypeDTO;
import com.codingfuture.erp.dto.MarketDTO;
import com.codingfuture.erp.service.MarketService;
import com.codingfuture.erp.util.DataResult;
import com.codingfuture.erp.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v2")
public class EchartsController {

    @Autowired
    private MarketService marketService;

    /**
     * @param year
     * @Description: 按月份渲染
     * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult < java.util.List < com.codingfuture.erp.dto.MarketDto>>>
     * @Author: Heyt
     * @date: 2024/9/5 17:30
     */
    @GetMapping("/echarts/month")
    public Result<DataResult<List<MarketDTO>>> getEcharts(Integer year) {
        List<MarketDTO> month = marketService.getMonthByYear(year);
        long size = month.size();

        DataResult<List<MarketDTO>> listDataResult = new DataResult<>(month, size);

        return Result.ok(listDataResult);
    }

    /**
     * @Description: 按商品分类渲染
     * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult < java.util.List < com.codingfuture.erp.dto.GoodsTypeDTO>>>
     * @Author: Heyt
     * @date: 2024/9/5 17:31
     */
    @GetMapping("/echarts/goodstype")
    public Result<DataResult<List<GoodsTypeDTO>>> getGoodsTypeEcharts() {
        List<GoodsTypeDTO> goodsTypeList = marketService.getGoodsTypeList();
        long size = goodsTypeList.size();

        DataResult<List<GoodsTypeDTO>> listDataResult = new DataResult<>(goodsTypeList, size);

        return Result.ok(listDataResult);
    }

}
