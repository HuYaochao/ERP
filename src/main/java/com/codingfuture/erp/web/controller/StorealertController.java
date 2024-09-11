package com.codingfuture.erp.web.controller;

import com.codingfuture.erp.entity.Storealert;
import com.codingfuture.erp.service.StorealertService;
import com.codingfuture.erp.util.Result;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v2")
public class StorealertController {

    @Autowired
    private StorealertService storealertService;
/**
 * @description:库存预警列表
 * @author: lxy
 * @date: 2024/9/7 10:15
 * @param: [page, rows]
 * @return: com.codingfuture.erp.util.Result<java.util.Map<java.lang.String,java.lang.Object>>
 **/
   @GetMapping("/storealert")
    public Result<Map<String,Object>> getstorealert(@RequestParam Integer page,
                                                    @RequestParam Integer rows){

     PageHelper.startPage(page,rows);
     List<Storealert> list = storealertService.getstorealert(page,rows);
     Integer num = storealertService.getstorealertCount(page,rows);
     Map<String,Object> map = new HashMap<>();
     map.put("rows",list);
     map.put("total",num);
     return Result.ok(map);
   }
}
