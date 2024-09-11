package com.codingfuture.erp.web.controller;

import com.codingfuture.erp.dto.AddInventoryQueryDTO;
import com.codingfuture.erp.dto.InventoryQueryDTO;
import com.codingfuture.erp.service.InventoryService;
import com.codingfuture.erp.util.DataResult;
import com.codingfuture.erp.util.Result;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v2")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    /**
     * @description:盘盈盘亏新增功能
     * @author: lxy
     * @date: 2024/9/7 10:08
     * @param: [addInventoryQueryDTO]
     * @return: com.codingfuture.erp.util.Result<?>
     **/
    @PostMapping("/inventory/add")
    public Result<?> addInventory(AddInventoryQueryDTO addInventoryQueryDTO) {
        Boolean flag = inventoryService.addInventory(addInventoryQueryDTO);
        if (flag) {
            return Result.ok("新增成功");
        }
        return Result.ok("新增失败");
    }
/**
 * @description:盘盈盘亏查询列表
 * @author: lxy
 * @date: 2024/9/7 10:11
 * @param: [inventoryQueryDTO]
 * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult<java.util.List<com.codingfuture.erp.dto.InventoryQueryDTO>>>
 **/
    @GetMapping("/inventory/listByPage")
    public Result<DataResult< List<InventoryQueryDTO>>> getInventoryListByPage(InventoryQueryDTO inventoryQueryDTO) {
        Page<Object> page = PageHelper.startPage(inventoryQueryDTO.getPage(), inventoryQueryDTO.getRows());
        List<InventoryQueryDTO> list = inventoryService.getInventoryListByPage(inventoryQueryDTO);
        DataResult<List<InventoryQueryDTO>> DataResult = new DataResult<>();
        DataResult.setRows(list);
        DataResult.setTotal(page.getTotal());
        return Result.ok(DataResult);
    }
/**
 * @description:盘盈盘亏编辑审核按钮
 * @author: lxy
 * @date: 2024/9/7 10:09
 * @param: [id]
 * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult<com.codingfuture.erp.dto.InventoryQueryDTO>>
 **/
    @GetMapping("/inventory/selectone")
    public Result<DataResult<InventoryQueryDTO>> getSelectone(Long id) {
        InventoryQueryDTO inventoryQueryDTO = inventoryService.getSelectone(id);
        DataResult<InventoryQueryDTO> objectDataResult = new DataResult<>();
        objectDataResult.setRows(inventoryQueryDTO);
        return Result.ok(objectDataResult);
    }
/**
 * @description:盘盈盘亏编辑成功按钮
 * @author: lxy
 * @date: 2024/9/7 10:13
 * @param: [addInventoryQueryDTO]
 * @return: com.codingfuture.erp.util.Result<java.lang.Void>
 **/
    @PostMapping("/inventory/update")
    public Result<Void> updateInventory(AddInventoryQueryDTO addInventoryQueryDTO) {
        Boolean flag  = inventoryService.updateInventory(addInventoryQueryDTO);
        if (flag){
            return Result.ok("编辑成功");
        }
        return Result.ok("编辑成功");

    }
/**
 * @description:盘盈盘亏删除删除功能
 * @author: lxy
 * @date: 2024/9/7 10:14
 * @param: [id]
 * @return: com.codingfuture.erp.util.Result<java.lang.Void>
 **/
    @DeleteMapping("/inventory")
    public Result<Void> deleteInventory(Long id){
        Boolean flag = inventoryService.deleteInventory(id);
        if (flag){
            return Result.ok("删除成功");
        }
        return Result.ok("删除失败");
    }

}