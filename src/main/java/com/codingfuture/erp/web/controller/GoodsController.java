package com.codingfuture.erp.web.controller;

import com.codingfuture.erp.dto.TypeGoodsDTO;
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
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsTypeService goodsTypeService;

    /**
     * @param pageNum
     * @param pageSize
     * @param typeGoodsDto
     * @Description: 查询商品列表
     * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult < java.util.List < com.codingfuture.erp.dto.TypeGoodsDTO>>>
     * @Author: Heyt
     * @date: 2024/9/5 10:25
     */
    // goods/listByPage
    @GetMapping("/goods/listByPage")
    public Result<DataResult<List<TypeGoodsDTO>>> findListByPage(@RequestParam("page") Integer pageNum,
                                                                 @RequestParam("rows") Integer pageSize,
                                                                 TypeGoodsDTO typeGoodsDto) {
        Page<TypeGoodsDTO> page = PageHelper.startPage(pageNum, pageSize);
        goodsService.findListByPage(typeGoodsDto);
        DataResult<List<TypeGoodsDTO>> listDataResult = new DataResult<>(page.getResult(), page.getTotal());
        page.close();
        return Result.ok(listDataResult);
    }

    /**
     * @Description: 查询商品类型
     * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult < java.util.List < com.codingfuture.erp.entity.GoodsType>>>
     * @Author: Heyt
     * @date: 2024/9/5 10:26
     */
    //  goods/goodstypelist
    @GetMapping("/goods/goodstypelist")
    public Result<DataResult<List<GoodsType>>> findType() {
        List<GoodsType> type = goodsTypeService.findType();
        long size = type.size();

        DataResult<List<GoodsType>> listDataResult = new DataResult<>(type, size);
        return Result.ok(listDataResult);
    }

    /**
     * @param id
     * @Description: 数据回显
     * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult < com.codingfuture.erp.dto.TypeGoodsDTO>>
     * @Author: Heyt
     * @date: 2024/9/5 10:26
     */
    // goods/selectone
    @GetMapping("/goods/selectone")
    public Result<DataResult<TypeGoodsDTO>> findById(Integer id) {
        DataResult<TypeGoodsDTO> supplierDataResult = new DataResult<>(goodsService.findById(id), 1L);
        System.out.println(goodsService.findById(id));
        return Result.ok(supplierDataResult);
    }

    /**
     * @param id
     * @Description: 删除
     * @return: com.codingfuture.erp.util.Result<java.lang.Void>
     * @Author: Heyt
     * @date: 2024/9/5 10:26
     */
    // goods
    @DeleteMapping("/goods")
    public Result<Void> deleteById(Integer id) {
        return goodsService.deleteById(id) ? Result.ok("删除成功") : Result.ok("删除失败");
    }

    /**
     * @param typeGoodsDto
     * @Description: 编辑
     * @return: com.codingfuture.erp.util.Result<java.lang.Void>
     * @Author: Heyt
     * @date: 2024/9/5 10:27
     */
    // goods/update
    @PostMapping("/goods/update")
    public Result<Void> updateById(TypeGoodsDTO typeGoodsDto) {
        return goodsService.updateById(typeGoodsDto) ? Result.ok("更新成功") : Result.ok("更新失败");
    }

    /**
     * @param typeGoodsDto
     * @Description: 新增
     * @return: com.codingfuture.erp.util.Result<java.lang.Void>
     * @Author: Heyt
     * @date: 2024/9/5 10:27
     */
    // goods/add
    @PostMapping("/goods/add")
    public Result<Void> add(TypeGoodsDTO typeGoodsDto) {
        GoodsType byName = goodsService.findByName(typeGoodsDto.getName().replace(" ", ""));

        if (Objects.nonNull(byName)) {
            return Result.ok("添加失败，商品已存在");
        } else {
            return goodsService.add(typeGoodsDto) ? Result.ok("添加成功") : Result.ok("添加失败");
        }
    }

//    ------------------------------------------------------------------------------------------------

    /**
     * @description:库存变动查询商品列表
     * @author: lxy
     * @date: 2024/9/8 15:40
     * @param: []
     * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult<java.util.List<com.codingfuture.erp.entity.Goods>>>
     **/
    @GetMapping("/storedetail/goodsList")
    public Result<DataResult<List<Goods>>> getGoodsList() {
        List<Goods> list = goodsService.getGoodsList();
        DataResult<List<Goods>> goodsDataResult = new DataResult<>();
        goodsDataResult.setRows(list);
        return Result.ok(goodsDataResult);
    }
}
