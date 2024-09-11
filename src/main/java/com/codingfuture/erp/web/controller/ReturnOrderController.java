package com.codingfuture.erp.web.controller;

import com.codingfuture.erp.service.ReturnOrderService;
import com.codingfuture.erp.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v2/returnorders")
public class ReturnOrderController {

    @Autowired
    private ReturnOrderService returnOrderService;

    @GetMapping("/listByPage")
    public Result<Map<String, Object>> listReturnOrdersByPage(
            @RequestParam(value = "state") int state,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "rows") int rows) {
        Map<String, Object> params = new HashMap<>();
        params.put("state", state);
        params.put("page", page);
        params.put("rows", rows);

        Map<String, Object> data = returnOrderService.getReturnOrdersByPage(params);
        return Result.ok(data);
    }
}
