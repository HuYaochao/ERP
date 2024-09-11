package com.codingfuture.erp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    @JsonProperty("goodsName")
    private String goodsName;
    @JsonProperty("goodsname")
    private String goodsname;
    private Long uuid;
    @JsonProperty("goodsuuid")
    private Long goodsuuid;
    private String name;
    private String origin;
    private String producer;
    private String unit;
    private Double inPrice;
    private Double outPrice;
    private Long goodsTypeUuid;
}
