package com.codingfuture.erp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDTO {
    private Long uuid;
    private Long goodsuuid;
    private String goodsname;
    private Double price;
    private Long num;
    private Double money;
    private String endername;
    private String storename;
    private String state;
    private Long ordersuuid;
}
