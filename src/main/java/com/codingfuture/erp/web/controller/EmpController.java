package com.codingfuture.erp.web.controller;


import com.codingfuture.erp.entity.Emp;
import com.codingfuture.erp.service.EmpService;
import com.codingfuture.erp.util.DataResult;
import com.codingfuture.erp.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v2")
public class EmpController {

    @Autowired
    private EmpService empService;
/**
 * @description:库存变动查询操作员
 * @author: lxy
 * @date: 2024/9/7 10:32
 * @param: []
 * @return: com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult<java.util.List<com.codingfuture.erp.entity.Emp>>>
 **/
    @GetMapping("/storeoper/emp_list") public Result<DataResult<List<Emp>>> getEmpList(){
        List<Emp> list = empService.getEmpList();
        DataResult<List<Emp>> empDataResult = new DataResult<>();
        empDataResult.setRows(list);
        return Result.ok(empDataResult);
}

}
