package com.codingfuture.erp.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Inventory {

    private Long uuid;
    private Long goodsUuid;
    private Long storeUuid;
    private Long num;
    private String type;
    private Date createTime;
    private Date checkTime;
    private String creater;
    private String checker;
    private String state;
    private String remark;
}
