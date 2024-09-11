package com.codingfuture.erp.dto;

import lombok.Data;

@Data
public class InventoryQueryDTO {

    private Long uuid;
    private Integer page;
    private Integer rows;
    private String goodsname;
    private String storename;
    private Long num;
    private String type;
    private String createtime;
    private String checktime;
    private String creater;
    private String checker;
    private String state;
    private String remark;
    private Long goodsuuid;
    private Long storeuuid;
}
