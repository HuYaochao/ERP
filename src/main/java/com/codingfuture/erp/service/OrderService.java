package com.codingfuture.erp.service;

import com.codingfuture.erp.dto.OrderDTO;
import com.codingfuture.erp.entity.Emp;
import com.codingfuture.erp.util.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 *
 * @author hyc
 * Date: 2024/9/9
 * @version 1.0
 */

public interface OrderService {
    Map<String, Object> getOrdersByPage(Map<String, Object> params);

    void addOrder(OrderDTO orderDTO, Emp currentUser);

    void doCheck(Long orderId, HttpServletRequest request) throws Exception;

    void doStart(Long orderId, HttpServletRequest request) throws Exception;
}