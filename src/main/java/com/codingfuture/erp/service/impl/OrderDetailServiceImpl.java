package com.codingfuture.erp.service.impl;

import com.codingfuture.erp.dto.OrderDetailDTO;
import com.codingfuture.erp.entity.OrderDetail;
import com.codingfuture.erp.mapper.OrderDetailMapper;
import com.codingfuture.erp.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public Map<String, Object> getOrderDetailsByPage(Map<String, Object> params) {
        int page = (int) params.get("page");
        int rows = (int) params.get("rows");
        int offset = (page - 1) * rows;

        params.put("offset", offset);
        params.put("limit", rows);

        List<OrderDetail> orderDetails = orderDetailMapper.selectOrderDetailsByPage(params);
        Long total = orderDetailMapper.countOrderDetails(params);

        Map<String, Object> result = new HashMap<>();
        result.put("total", total);
        result.put("rows", convertToDTO(orderDetails));
        return result;
    }

    private List<OrderDetailDTO> convertToDTO(List<OrderDetail> orderDetails) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return orderDetails.stream().map(orderDetail -> {
            OrderDetailDTO dto = new OrderDetailDTO();
            dto.setUuid(orderDetail.getUuid());
            dto.setGoodsname(orderDetail.getGoodsName());
            dto.setPrice(orderDetail.getPrice());
            dto.setNum(orderDetail.getNum());
            dto.setMoney(orderDetail.getMoney());
            dto.setEndername(orderDetail.getEnderName());
            dto.setStorename(orderDetail.getStoreName());
            dto.setState(orderDetail.getState());
            dto.setOrdersuuid(orderDetail.getOrdersUuid());
            return dto;
        }).collect(Collectors.toList());
    }


    @Override
    public List<OrderDetailDTO> getOrderDetailsByOrderUuids(List<Long> orderUuids) {
        // 查询订单详情的实现
        return orderDetailMapper.selectByOrderUuids(orderUuids);
    }
}