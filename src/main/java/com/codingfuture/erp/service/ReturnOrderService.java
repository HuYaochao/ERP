package com.codingfuture.erp.service;

import java.util.Map;

public interface ReturnOrderService {
    Map<String, Object> getReturnOrdersByPage(Map<String, Object> params);
}