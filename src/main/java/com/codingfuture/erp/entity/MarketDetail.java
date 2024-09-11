package com.codingfuture.erp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MarketDetail {
    private Long uuid;
    @JsonProperty("goodsuuid")
    private Long goodsUuid;
    @JsonProperty("goodsname")
    private String goodsName;
    private Double price;
    private Integer num;
    private Double money;
    private Date endTime;
    private String ender;
    private Long storeUuid;
    private String state;
    private Long marketUuid;


}
