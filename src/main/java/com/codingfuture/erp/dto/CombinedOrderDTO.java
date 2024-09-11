package com.codingfuture.erp.dto;

import lombok.Data;

import java.util.List;

@Data
public class CombinedOrderDTO {
    private Long uuid;
    private String goodsname;
    private Double price;
    private Long num;
    private Double money;
    private String endername;
    private String storename;
    private String state;
    private String createtime;
    private String checktime;
    private String starttime;
    private String endtime;
    private String type;
    private String creatername;
    private String checkername;
    private String startername;
    private String suppliername;
    private Long supplieruuid;
    private Double totalmoney;
    private Long waybills;
    private Double score;
}