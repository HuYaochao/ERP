package com.codingfuture.erp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long uuid;
    private Date createTime;
    private Date checkTime;
    private Date startTime;
    private Date endTime;
    private String type;
    private String createrName;
    private Long creater;
    private String checkerName;
    private String starterName;
    private String enderName;
    private String supplierName;
    private Long supplierUuid;
    private Double totalMoney;
    private String state;
    private Long waybills;
    private Double score;


}