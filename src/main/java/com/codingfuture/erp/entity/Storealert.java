package com.codingfuture.erp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Storealert {
    private Long uuid;
    private String name;
    @JsonProperty("storenum")
    private Long storenum;
    @JsonProperty("outnum")
    private Long outnum;
}
