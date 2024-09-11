package com.codingfuture.erp.web.controller;

import com.codingfuture.erp.entity.Goods;
import com.codingfuture.erp.entity.Store;
import com.codingfuture.erp.service.GoodsService;
import com.codingfuture.erp.service.StoreService;
import com.codingfuture.erp.util.DataResult;
import com.codingfuture.erp.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/v2/inventory")
public class StoreChangeController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private StoreService storeService;
/**
 * @description:盘盈盘亏编辑按钮弹窗查询商品列表
 * @author: lxy
 * @date: 2024/9/7 10:19
 * @param: []
 * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult<java.util.List<com.codingfuture.erp.entity.Goods>>>
 **/
    @GetMapping("/goodsList")
    public Result<DataResult<List<Goods>>> getChangeGoodsList(){
     List<Goods> changeGoodsList = goodsService.getChangeGoodsList();
        DataResult<List<Goods>> objectDataResult = new DataResult<>();
        objectDataResult.setRows(changeGoodsList);
        return Result.ok(objectDataResult);
    }
/**
 * @description:盘盈盘亏编辑按钮弹窗查询库存列表
 * @author: lxy
 * @date: 2024/9/7 10:20
 * @param: []
 * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult<java.util.List<com.codingfuture.erp.entity.Store>>>
 **/
    @GetMapping("/storeList")
    public Result<DataResult<List<Store>>> getChangeStoreList(){
        List<Store> changeStoreList = storeService.getChangeStoreList();
        DataResult<List<Store>> objectDataResult = new DataResult<>();
        objectDataResult.setRows(changeStoreList);
        return Result.ok(objectDataResult);
    }

}
