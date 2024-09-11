package com.codingfuture.erp.web.controller;

import com.codingfuture.erp.dto.OrderDTO;
import com.codingfuture.erp.entity.Emp;
import com.codingfuture.erp.entity.Supplier;
import com.codingfuture.erp.service.OrderDetailService;
import com.codingfuture.erp.service.OrderService;
import com.codingfuture.erp.service.SupplierService;
import com.codingfuture.erp.util.DataResult;
import com.codingfuture.erp.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v2/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/listByPage")
    public Result<Map<String, Object>> listOrdersByPage(
            @RequestParam(value = "state", required = false) Integer state,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "rows") int rows) {

        Map<String, Object> params = new HashMap<>();
        params.put("page", page);
        params.put("rows", rows);

        if (state != null) {
            // If state is provided, handle the order listing with specific state
            params.put("state", state);
        }

        // Query orders with provided parameters or all orders if state is not provided
        Map<String, Object> data = orderService.getOrdersByPage(params);
        return Result.ok(data);
    }


    @GetMapping("/showsupplier")
    public Result<DataResult<List<Supplier>>> showSupplier(@RequestParam String type) {
        try {
            // 查询供应商列表
            List<Supplier> suppliers = supplierService.getSuppliersByType(type);

            // 封装 rows 和 total
            DataResult<List<Supplier>> dataResult = new DataResult<>();
            dataResult.setRows(suppliers);
            dataResult.setTotal((long) suppliers.size());

            // 返回封装后的结果
            return Result.ok(dataResult);
        } catch (Exception e) {
            return Result.err("Failed to retrieve suppliers: " + e.getMessage());
        }
    }

    @PostMapping("/add")
    public Result<?> addOrder(@RequestBody OrderDTO orderDTO, HttpSession session) {
        try {
            // 获取当前登录用户
            Emp currentUser = (Emp) session.getAttribute("currentUser");
            if (currentUser == null) {
                return Result.err("用户未登录");
            }

            // 调用服务层，添加订单并传递当前用户
            orderService.addOrder(orderDTO, currentUser);
            return Result.ok("订单新增成功");
        } catch (Exception e) {
            return Result.err("订单新增失败：" + e.getMessage());
        }
    }


    @PostMapping("/doCheck")
    public Result<?> doCheck(@RequestParam("id") Long orderId, HttpServletRequest request) {
        try {
            orderService.doCheck(orderId, request);
            return Result.ok("订单审核成功");
        } catch (Exception e) {
            return Result.err("订单审核失败：" + e.getMessage());
        }
    }

    @PostMapping("/doStart")
    public Result<?> doStart(@RequestParam("id") Long orderId, HttpServletRequest request) {
        try {
            orderService.doStart(orderId, request);
            return Result.ok("订单确认成功");
        } catch (Exception e) {
            return Result.err("订单确认失败：" + e.getMessage());
        }
    }

}