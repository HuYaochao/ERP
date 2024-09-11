package com.codingfuture.erp.mapper;

import com.codingfuture.erp.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
/**
 *
 * @author hyc
 * Date: 2024/9/4
 * @version 1.0
 */


@Mapper
public interface ReturnOrderMapper {
    List<Order> selectReturnOrdersByPage(Map<String, Object> params);
    int countReturnOrders(Map<String, Object> params);
}