package com.codingfuture.erp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeGoodsDTO {
    private Long uuid;
    private String name;
    private String origin;
    private String producer;
    private String unit;
    private Double inPrice;
    private Double outPrice;

    private String goodsType;
}
