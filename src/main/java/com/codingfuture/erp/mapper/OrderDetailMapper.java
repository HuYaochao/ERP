package com.codingfuture.erp.mapper;

import com.codingfuture.erp.dto.OrderDetailDTO;
import com.codingfuture.erp.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDetailMapper {
    List<OrderDetail> selectOrderDetailsByOrderId(Long orderId);

    List<OrderDetail> selectOrderDetailsByPage(Map<String, Object> params);

    Long countOrderDetails(Map<String, Object> params);
    // 添加其他 CRUD 方法

    List<OrderDetailDTO> selectByOrderUuids(@Param("orderUuids") List<Long> orderUuids);

//    void insertOrderDetails(@Param("orderDetails") List<OrderDetail> orderDetails);

    void insertOrderDetails(@Param("list") List<OrderDetail> orderDetails);

    List<OrderDetail> selectOrderDetailsByOrders(@Param("orderIds") List<Long> orderIds);
}