package com.codingfuture.erp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDetail {
    private Long uuid;
    @JsonProperty("storeuuid")
    private Long storeUuid;
    @JsonProperty("goodsuuid")
    private Long goodsUuid;
    private Long num;

}
