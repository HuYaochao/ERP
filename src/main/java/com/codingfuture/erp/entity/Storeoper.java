package com.codingfuture.erp.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Storeoper {
    private Long uuid;
    private Long empUuid;
    private Date operTime;
    private Long storeUuid;
    private Long goodsUuid;
    private Long num;
    private String type;
}
