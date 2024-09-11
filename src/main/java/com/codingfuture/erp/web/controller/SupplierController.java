package com.codingfuture.erp.web.controller;

import com.codingfuture.erp.dto.SupplierDTO;
import com.codingfuture.erp.entity.GoodsType;
import com.codingfuture.erp.service.SupplierService;
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
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    /**
     * @param pageNum
     * @param pageSize
     * @param type
     * @param supplierDTO
     * @Description: 数据渲染
     * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult < java.util.List < com.codingfuture.erp.dto.SupplierDTO>>>
     * @Author: Heyt
     * @date: 2024/9/5 10:31
     */
    // /v2/supplier/listByPage?t1.type=1
    @GetMapping("/supplier/listByPage")
    public Result<DataResult<List<SupplierDTO>>> findListByPage(@RequestParam("page") Integer pageNum,
                                                                @RequestParam("rows") Integer pageSize,
                                                                @RequestParam("t1.type") String type,
                                                                SupplierDTO supplierDTO) {
        Page<SupplierDTO> page = PageHelper.startPage(pageNum, pageSize);
        supplierService.findListByPage(type, supplierDTO);

        DataResult<List<SupplierDTO>> dataResult = new DataResult<>(page.getResult(), page.getTotal());
        page.close();
        return Result.ok(dataResult);
    }

    /**
     * @param id
     * @Description: 数据回显
     * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult < com.codingfuture.erp.dto.SupplierDTO>>
     * @Author: Heyt
     * @date: 2024/9/5 10:32
     */
    // supplier/selectone
    @GetMapping("/supplier/selectone")
    public Result<DataResult<SupplierDTO>> findById(Integer id) {
        DataResult<SupplierDTO> supplierDataResult = new DataResult<>(supplierService.findById(id), 1L);

        return Result.ok(supplierDataResult);
    }

    /**
     * @param id
     * @Description: 删除
     * @return: com.codingfuture.erp.util.Result<java.lang.Void>
     * @Author: Heyt
     * @date: 2024/9/5 10:32
     */
    // supplier
    @DeleteMapping("/supplier")
    public Result<Void> deleteById(Integer id) {
        return supplierService.deleteById(id) ? Result.ok("删除成功") : Result.err("删除失败");
    }

    /**
     * @param supplierDTO
     * @Description: 编辑
     * @return: com.codingfuture.erp.util.Result<java.lang.Void>
     * @Author: Heyt
     * @date: 2024/9/5 10:32
     */
    // supplier/update
    @PostMapping("/supplier/update")
    public Result<Void> updateById(SupplierDTO supplierDTO) {
        return supplierService.updateById(supplierDTO) ? Result.ok("更新成功") : Result.err("更新失败");
    }

    /**
     * @param type
     * @param supplierDTO
     * @Description: 新增
     * @return: com.codingfuture.erp.util.Result<java.lang.Void>
     * @Author: Heyt
     * @date: 2024/9/5 10:32
     */
    // supplier/add?t.type=1
    @PostMapping("/supplier/add")
    public Result<Void> add(@RequestParam("t.type") String type,
                            SupplierDTO supplierDTO) {
        return supplierService.add(type, supplierDTO) ? Result.ok("添加成功") : Result.err("添加失败");

    }


}