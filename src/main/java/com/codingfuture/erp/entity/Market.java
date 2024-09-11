package com.codingfuture.erp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Market {
    private Long uuid;
    private Date createTime;
    private Date endTime;
    private String creater;
    private String ender;
    private Long supplierUuid;
    private Double totalMoney;
    private String state;
    private Integer waybills;
}
