package com.codingfuture.erp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsSaleDTO {
    private Long uuid;
    private Long goodsuuid;
    private String goodsname;
    private Double price;
    private Long num;
    private Double money;

    private String state;

    private Long marketuuid;
    private Long storeuuid;

}
