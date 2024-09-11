package com.codingfuture.erp.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OperListDTO {
    private Long uuid;
    private String empName;
    private Date opertime;
    private String storeName;
    private String goodsName;
    private Long num;
    private String type;

}
