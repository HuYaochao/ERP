package com.codingfuture.erp.web.controller;

import com.codingfuture.erp.dto.OperListDTO;
import com.codingfuture.erp.dto.OperQueryDTO;
import com.codingfuture.erp.entity.Goods;
import com.codingfuture.erp.entity.Store;
import com.codingfuture.erp.service.StoreoperService;
import com.codingfuture.erp.service.GoodsService;
import com.codingfuture.erp.service.StoreService;
import com.codingfuture.erp.util.DataResult;
import com.codingfuture.erp.util.Result;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2")
public class StoreoperController {

    @Autowired
    private StoreoperService storeoperService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private GoodsService goodsService;
/**
 * @description:库存变动记录查询仓库列表
 * @author: lxy
 * @date: 2024/9/7 10:03
 * @param: []
 * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult<java.util.List<com.codingfuture.erp.entity.Store>>>
 **/
    @GetMapping("/storeoper/store_list")
    public Result<DataResult<List<Store>>> getStoreList() {
        List<Store> storeList = storeService.getStoreList();
        DataResult<List<Store>> objectDataResult = new DataResult<>();
        objectDataResult.setRows(storeList);
        return Result.ok(objectDataResult);
    }
/**
 * @description:库存变动记录查询商品列表
 * @author: lxy
 * @date: 2024/9/7 10:04
 * @param: []
 * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult<java.util.List<com.codingfuture.erp.entity.Goods>>>
 **/
    @GetMapping("/storeoper/goods_list")
    public Result<DataResult<List<Goods>>> getGoodsList() {
        List<Goods> goodsList = goodsService.getGoodsList();
        DataResult<List<Goods>> objectDataResult = new DataResult<>();
        objectDataResult.setRows(goodsList);
        return Result.ok(objectDataResult);
    }
/**
 * @description:库存变动记录查询列表
 * @author: lxy
 * @date: 2024/9/7 10:07
 * @param: [operQueryDTO]
 * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult<java.util.List<com.codingfuture.erp.dto.OperListDTO>>>
 **/
    @GetMapping("/storeoper")
    public Result<DataResult<List<OperListDTO>>> getOperList(@ModelAttribute OperQueryDTO operQueryDTO) {
        Page<OperListDTO> page = PageHelper.startPage(operQueryDTO.getPage(), operQueryDTO.getRows());
        storeoperService.getOperList(operQueryDTO);
        DataResult<List<OperListDTO>> objectDataResult = new DataResult<>(page.getResult(), page.getTotal());
        return Result.ok(objectDataResult);
    }

}
