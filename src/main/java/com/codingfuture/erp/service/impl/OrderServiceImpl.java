package com.codingfuture.erp.service.impl;

import com.codingfuture.erp.constant.OrderStatusConstants;
import com.codingfuture.erp.dto.OrderDTO;
import com.codingfuture.erp.dto.OrderDetailDTO;
import com.codingfuture.erp.entity.Emp;
import com.codingfuture.erp.entity.Order;
import com.codingfuture.erp.entity.OrderDetail;
import com.codingfuture.erp.mapper.OrderDetailMapper;
import com.codingfuture.erp.mapper.OrderMapper;
import com.codingfuture.erp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public Map<String, Object> getOrdersByPage(Map<String, Object> params) {
        int page = (int) params.get("page");
        int rows = (int) params.get("rows");
        int offset = (page - 1) * rows;

        params.put("offset", offset);
        params.put("limit", rows);

        // 查询订单列表
        List<Order> orders = orderMapper.selectOrdersByPage(params);

        // 查询总记录数
        Long total = orderMapper.countOrders(params);

        // 获取所有订单ID
        List<Long> orderIds = orders.stream()
                .map(Order::getUuid)
                .collect(Collectors.toList());

        // 查询订单详情
        List<OrderDetail> orderDetails = orderDetailMapper.selectOrderDetailsByOrders(orderIds);

        // 转换订单详情为 DTO
        Map<Long, List<OrderDetailDTO>> orderDetailMap = orderDetails.stream()
                .collect(Collectors.groupingBy(OrderDetail::getOrdersUuid,
                        Collectors.mapping(this::convertOrderDetailToDTO, Collectors.toList())));

        // 转换订单为 DTO，并设置订单详情
        List<OrderDTO> orderDTOs = convertToDTO(orders);
        orderDTOs.forEach(dto -> dto.setOrderDetailList(orderDetailMap.get(dto.getUuid())));

        // 构建返回结果
        Map<String, Object> result = new HashMap<>();
        result.put("total", total);
        result.put("rows", orderDTOs);  // 确保这里是 List<OrderDTO>
        return result;
    }



    public List<OrderDTO> convertToDTO(List<Order> orders) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return orders.stream().map(order -> {
            OrderDTO dto = new OrderDTO();
            dto.setUuid(order.getUuid());
            dto.setCreatetime(order.getCreateTime() != null ? sdf.format(order.getCreateTime()) : "");
            dto.setChecktime(order.getCheckTime() != null ? sdf.format(order.getCheckTime()) : "");
            dto.setStarttime(order.getStartTime() != null ? sdf.format(order.getStartTime()) : "");
            dto.setEndtime(order.getEndTime() != null ? sdf.format(order.getEndTime()) : "");
            dto.setType(order.getType());
            dto.setCreatername(order.getCreaterName());
            dto.setCheckername(order.getCheckerName());
            dto.setStartername(order.getStarterName());
            dto.setEndername(order.getEnderName());
            dto.setSuppliername(order.getSupplierName());
            dto.setSupplieruuid(order.getSupplierUuid());
            dto.setTotalmoney(order.getTotalMoney());
            dto.setState(order.getState());
            dto.setWaybills(order.getWaybills());
            dto.setScore(order.getScore());
            return dto;
        }).collect(Collectors.toList());
    }

    private OrderDetailDTO convertOrderDetailToDTO(OrderDetail orderDetail) {
        OrderDetailDTO dto = new OrderDetailDTO();
        dto.setUuid(orderDetail.getUuid());
        dto.setGoodsuuid(orderDetail.getGoodsUuid());
        dto.setGoodsname(orderDetail.getGoodsName());
        dto.setPrice(orderDetail.getPrice());
        dto.setNum(orderDetail.getNum());
        dto.setMoney(orderDetail.getMoney());
        dto.setEndername(orderDetail.getEnderName());
        dto.setStorename(orderDetail.getStoreName());
        dto.setState(orderDetail.getState());
        dto.setOrdersuuid(orderDetail.getOrdersUuid());
        return dto;
    }



    @Transactional
    @Override
    public void addOrder(OrderDTO orderDTO, Emp currentUser) {
        // 创建订单实体
        Order order = new Order();
        order.setSupplierUuid(orderDTO.getSupplieruuid());
        order.setCreateTime(new Date());

        // 计算订单总金额
        double totalMoney = orderDTO.getOrderDetails().stream()
                .mapToDouble(detail -> detail.getMoney())
                .sum();
        order.setTotalMoney(totalMoney);  // 设置总金额

        order.setCreater(currentUser.getUuid());  // 设置创建人为当前用户
        order.setState("0");  // 初始状态
        try {
            // 插入订单并获取订单UUID
            orderMapper.insertOrder(order);
            Long orderId = order.getUuid();  // 获取插入后的订单ID

            // 插入订单详情
            List<OrderDetail> orderDetails = orderDTO.getOrderDetails().stream().map(detailDTO -> {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setGoodsUuid(detailDTO.getGoodsuuid());
                orderDetail.setGoodsName(detailDTO.getGoodsname());
                orderDetail.setPrice(detailDTO.getPrice());
                orderDetail.setNum(detailDTO.getNum());
                orderDetail.setMoney(detailDTO.getMoney());
                orderDetail.setOrdersUuid(orderId);  // 设置订单详情中的订单UUID
                System.out.println("订单ID：" + orderId);

                return orderDetail;
            }).collect(Collectors.toList());

            // 批量插入订单详情
            orderDetailMapper.insertOrderDetails(orderDetails);
        } catch (Exception e) {
            // 捕获异常并打印日志
            System.err.println("订单插入异常: " + e.getMessage());
            throw e;  // 确保事务回滚
        }

    }


    @Transactional
    @Override
    public void doCheck(Long orderId, HttpServletRequest request) throws Exception {
        // 获取当前登录用户
        Emp currentUser = (Emp) request.getSession().getAttribute("currentUser");
        if (currentUser == null) {
            throw new Exception("用户未登录");
        }

        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();
        Date checkTime = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());

        // 更新订单状态为审核通过
        orderMapper.updateOrderStatus(orderId,
                String.valueOf(currentUser.getUuid()),
                checkTime, OrderStatusConstants.REVIEWED.toString());  // "1" 表示已审核
    }

    @Transactional
    @Override
    public void doStart(Long orderId, HttpServletRequest request) throws Exception {
        // 获取当前登录用户
        Emp currentUser = (Emp) request.getSession().getAttribute("currentUser");
        if (currentUser == null) {
            throw new Exception("用户未登录");
        }

        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();
        Date startTime = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());

        // 更新订单状态为已确认
        orderMapper.updateOrderStartStatus(orderId,
                String.valueOf(currentUser.getUuid()),
                startTime,
                OrderStatusConstants.CONFIRMED.toString());
    }



}