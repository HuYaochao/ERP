package com.codingfuture.erp.web.controller;

import com.codingfuture.erp.dto.StoreDTO;
import com.codingfuture.erp.dto.StoreGoodsDTO;
import com.codingfuture.erp.entity.GoodsType;
import com.codingfuture.erp.entity.Store;
import com.codingfuture.erp.service.StoreService;
import com.codingfuture.erp.util.DataResult;
import com.codingfuture.erp.util.Result;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v2")
public class StoreController {
    @Autowired
    private StoreService storeService;

    /**
     * @param pageNum
     * @param pageSize
     * @param storeDTO
     * @Description: 查询仓库
     * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult < java.util.List < com.codingfuture.erp.dto.StoreDTO>>>
     * @Author: Heyt
     * @date: 2024/9/5 10:30
     */
    // store/listByPage
    @GetMapping("/store/listByPage")
    public Result<DataResult<List<StoreDTO>>> findListByPage(@RequestParam("page") Integer pageNum,
                                                             @RequestParam("rows") Integer pageSize,
                                                             StoreDTO storeDTO) {
        Page<StoreDTO> page = PageHelper.startPage(pageNum, pageSize);
        storeService.findListByPage(storeDTO);
        System.out.println(storeDTO);
        DataResult<List<StoreDTO>> listDataResult = new DataResult<>(page.getResult(), page.getTotal());
        page.close();
        return Result.ok(listDataResult);
    }

    /**
     * @param id
     * @Description: 数据回显
     * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult < com.codingfuture.erp.entity.Store>>
     * @Author: Heyt
     * @date: 2024/9/5 10:30
     */
    // goodstype/selectone
    @GetMapping("/store/selectone")
    public Result<DataResult<Store>> findById(Integer id) {
        DataResult<Store> supplierDataResult = new DataResult<>(storeService.findById(id), 1L);
        return Result.ok(supplierDataResult);
    }

    /**
     * @param id
     * @Description: 删除
     * @return: com.codingfuture.erp.util.Result<java.lang.Void>
     * @Author: Heyt
     * @date: 2024/9/5 10:30
     */
    // store
    @DeleteMapping("/store")
    public Result<Void> deleteById(Integer id) {
        return storeService.deleteById(id) ? Result.ok("删除成功") : Result.err("删除失败");
    }

    /**
     * @param storeDTO
     * @Description: 编辑
     * @return: com.codingfuture.erp.util.Result<java.lang.Void>
     * @Author: Heyt
     * @date: 2024/9/5 10:31
     */
    // store/update
    @PostMapping("/store/update")
    public Result<Void> updateById(StoreDTO storeDTO) {
        return storeService.updateById(storeDTO) ? Result.ok("更新成功") : Result.err("更新失败");
    }

    /**
     * @param storeDTO
     * @Description: 新增
     * @return: com.codingfuture.erp.util.Result<java.lang.Void>
     * @Author: Heyt
     * @date: 2024/9/5 10:31
     */
    // store/add?t.type=1
    @PostMapping("/store/add")
    public Result<Void> add(StoreDTO storeDTO) {
        StoreDTO byName = storeService.findByName(storeDTO.getName().replace(" ", ""));

        if (Objects.nonNull(byName)) {
            return Result.ok("添加失败，仓库已存在");
        } else {
            return storeService.add(storeDTO) ? Result.ok("添加成功") : Result.ok("添加失败");
        }

    }


//    -------------------------------------------------------------------------------


 /**
  * @description:库存查询查询列表
  * @author: lxy 
  * @date: 2024/9/7 9:57
  * @param: []
  * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult<java.util.List<com.codingfuture.erp.entity.Store>>>
  **/
    
    @GetMapping("/storedetail/storeList")
    public Result<DataResult<List<Store>>> getStoreList() {
        List<Store> list = storeService.getStoreList();
        DataResult<List<Store>> storeDataResult = new DataResult<>();
        storeDataResult.setRows(list);
        return Result.ok(storeDataResult);
    }
/**
 * @description:库存查询搜索功能
 * @author: lxy
 * @date: 2024/9/7 10:00
 * @param: [page, rows, storeName, goodsName]
 * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult<java.util.List<com.codingfuture.erp.dto.StoreGoodsDTO>>>
 **/
    @GetMapping("/storedetail")
    public Result<DataResult<List<StoreGoodsDTO>>> getStoreDetail(@RequestParam("page") Integer page,
                                                                  @RequestParam("rows") Integer rows,
                                                                  @RequestParam(value = "storeName", required = false) Long storeName,
                                                                  @RequestParam(value = "goodsName", required = false) Long goodsName) {
        PageHelper.startPage(page, rows);
        List<StoreGoodsDTO> list = storeService.getStoreDetail(storeName, goodsName);
        DataResult<List<StoreGoodsDTO>> storeGoodsDTODataResult = new DataResult<>();
        storeGoodsDTODataResult.setRows(list);
        Integer storeDetailCount = storeService.getStoreDetailCount(storeName, goodsName);
        storeGoodsDTODataResult.setTotal((long) storeDetailCount);
        return Result.ok(storeGoodsDTODataResult);
    }
}
