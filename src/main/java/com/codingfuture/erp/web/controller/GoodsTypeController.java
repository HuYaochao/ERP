package com.codingfuture.erp.web.controller;

import com.codingfuture.erp.entity.Goods;
import com.codingfuture.erp.entity.GoodsType;
import com.codingfuture.erp.service.GoodsService;
import com.codingfuture.erp.service.GoodsTypeService;
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
public class GoodsTypeController {
    @Autowired
    private GoodsTypeService goodsTypeService;
    @Autowired
    private GoodsService goodsService;

    /**
     * @param pageNum
     * @param pageSize
     * @param name
     * @Description: 查询商品类型
     * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult < java.util.List < com.codingfuture.erp.entity.GoodsType>>>
     * @Author: Heyt
     * @date: 2024/9/5 10:16
     */

    //goodstype/listByPage
    @GetMapping("/goodstype/listByPage")
    public Result<DataResult<List<GoodsType>>> findListByPage(@RequestParam("page") Integer pageNum,
                                                              @RequestParam("rows") Integer pageSize,
                                                              String name) {
        Page<GoodsType> page = PageHelper.startPage(pageNum, pageSize);

        goodsTypeService.findListByPage(name);

        DataResult<List<GoodsType>> listDataResult = new DataResult<>(page.getResult(), page.getTotal());
        page.close();

        return Result.ok(listDataResult);
    }


    /**
     * @param id
     * @Description: 单个数据回显
     * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult < com.codingfuture.erp.entity.GoodsType>>
     * @Author: Heyt
     * @date: 2024/9/5 10:16
     */

    // goodstype/selectone
    @GetMapping("/goodstype/selectone")
    public Result<DataResult<GoodsType>> findById(Integer id) {
        DataResult<GoodsType> supplierDataResult = new DataResult<>(goodsTypeService.findById(id), 1L);
        return Result.ok(supplierDataResult);
    }

    /**
     * @param foreignKeyId
     * @Description: 检查外键约束
     * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult < com.codingfuture.erp.entity.GoodsType>>
     * @Author: Heyt
     * @date: 2024/9/7 16:10
     */
    // goodstype/check
    @GetMapping("/goodstype/check")
    public Result<DataResult<List<Goods>>> check(Long foreignKeyId) {
        List<Goods> list = goodsService.check(foreignKeyId);
        long size = list.size();
        DataResult<List<Goods>> listDataResult = new DataResult<>(list, size);
        return Result.ok(listDataResult);
    }

    /**
     * @param id
     * @Description: 商品类型删除
     * @return: com.codingfuture.erp.util.Result<java.lang.Void>
     * @Author: Heyt
     * @date: 2024/9/5 10:17
     */
    // goodstype
    @DeleteMapping("/goodstype")
    public Result<Void> deleteById(Integer id) {
        return goodsTypeService.deleteById(id) ? Result.ok("删除成功") : Result.ok("删除失败，该商品类型存在商品");
    }

    /**
     * @param goodsType
     * @Description: 编辑
     * @return: com.codingfuture.erp.util.Result<java.lang.Void>
     * @Author: Heyt
     * @date: 2024/9/5 10:18
     */
    // goodstype/update
    @PostMapping("/goodstype/update")
    public Result<Void> updateById(GoodsType goodsType) {
        return goodsTypeService.updateById(goodsType) ? Result.ok("更新成功") : Result.ok("更新失败");
    }

    /**
     * @param name
     * @Description: 新增
     * @return: com.codingfuture.erp.util.Result<java.lang.Void>
     * @Author: Heyt
     * @date: 2024/9/5 10:18
     */
    // goodstype/add?t.type=1
    @PostMapping("/goodstype/add")
    public Result<Void> add(String name) {
        GoodsType byName = goodsTypeService.findByName(name.replace(" ", ""));

        if (Objects.nonNull(byName)) {
            return Result.ok("添加失败，商品类型已存在");
        } else {
            return goodsTypeService.add(name) ? Result.ok("添加成功") : Result.ok("添加失败");
        }

    }
}