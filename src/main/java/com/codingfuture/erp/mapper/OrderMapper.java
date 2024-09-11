package com.codingfuture.erp.mapper;

import com.codingfuture.erp.dto.OrderDTO;
import com.codingfuture.erp.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {
    List<Order> selectOrdersByPage(Map<String, Object> params);
    Long countOrders(Map<String, Object> params);
    void insertOrder(Order order);

    void updateOrderStatus(@Param("orderId") Long orderId,
                           @Param("checker") String checker,
                           @Param("checkTime") Date checkTime,
                           @Param("state") String state);

    // 更新订单的确认状态
    void updateOrderStartStatus(@Param("orderId") Long orderId,
                                @Param("starter") String starter,
                                @Param("startTime") Date startTime,
                                @Param("state") String state);
}