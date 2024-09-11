package com.codingfuture.erp.service.impl;

import com.codingfuture.erp.dto.OrderDTO;
import com.codingfuture.erp.entity.Order;
import com.codingfuture.erp.mapper.ReturnOrderMapper;
import com.codingfuture.erp.service.ReturnOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReturnOrderServiceImpl implements ReturnOrderService {

    @Autowired
    private ReturnOrderMapper returnOrderMapper;

    @Override
    public Map<String, Object> getReturnOrdersByPage(Map<String, Object> params) {
        int page = (int) params.get("page");
        int rows = (int) params.get("rows");
        int offset = (page - 1) * rows;

        params.put("offset", offset);
        params.put("limit", rows);

        List<Order> orders = returnOrderMapper.selectReturnOrdersByPage(params);
        int total = returnOrderMapper.countReturnOrders(params);

        Map<String, Object> result = new HashMap<>();
        result.put("total", total);
        result.put("rows", convertToDTO(orders));
        return result;
    }

    public List<OrderDTO> convertToDTO(List<Order> orders) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 假设有合适的转换逻辑
        return orders.stream().map(order -> {
            OrderDTO dto = new OrderDTO();
            dto.setUuid(order.getUuid());
            dto.setCreatetime(order.getCreateTime() != null ? sdf.format(order.getCreateTime()) : "");
            dto.setChecktime(order.getCheckTime() != null ? sdf.format(order.getCheckTime()) : "");
            dto.setStarttime(order.getStartTime() != null ? sdf.format(order.getStartTime()) : "");
            dto.setEndtime(order.getEndTime() != null ? sdf.format(order.getEndTime()) : "");
            dto.setCreatername(order.getCreaterName()); // 转换为员工名称，如果需要
            dto.setCheckername(order.getCheckerName()); // 转换为员工名称
            dto.setStartername(order.getStarterName()); // 转换为员工名称
            dto.setEndername(order.getEnderName()); // 转换为员工名称
            dto.setSuppliername(order.getSupplierName()); // 转换为供应商名称
            dto.setTotalmoney(order.getTotalMoney());
            dto.setState(order.getState());
            dto.setWaybills(order.getWaybills());
            dto.setScore(order.getScore());

            return dto;
        }).collect(Collectors.toList());
    }
}