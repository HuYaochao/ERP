package com.codingfuture.erp.entity;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDetail {
    private Long uuid;
    private Long goodsUuid;
    private String goodsName;
    private Double price;
    private Long num;
    private Double money;
    private Date endTime;
    private String enderName;
    private Long storeUuid;
    private String storeName;
    private String state;
    private Long ordersUuid;
}