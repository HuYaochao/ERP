package com.codingfuture.erp.dto;

import com.codingfuture.erp.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long uuid;
    private String createtime;
    private String checktime;
    private String starttime;
    private String endtime;
    private String type;
    private String creatername; // 变成员工名称
    private String checkername; // 变成员工名称
    private String startername; // 变成员工名称
    private String endername; // 变成员工名称
    private String suppliername; // 供应商名称
    private Long supplieruuid;
    private Double totalmoney;
    private String state;
    private Long waybills;
    private Double score;
    private List<OrderDetailDTO> orderDetails;
    private List<OrderDetailDTO> orderDetailList;
}




