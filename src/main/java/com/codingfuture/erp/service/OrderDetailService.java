package com.codingfuture.erp.service;

import com.codingfuture.erp.dto.OrderDetailDTO;

import java.util.List;
import java.util.Map;

public interface OrderDetailService {
    Map<String, Object> getOrderDetailsByPage(Map<String, Object> params);
    List<OrderDetailDTO> getOrderDetailsByOrderUuids(List<Long> orderUuids);
}