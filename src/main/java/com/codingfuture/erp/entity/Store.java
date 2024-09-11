package com.codingfuture.erp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    @JsonProperty("storeName")
    private  String storeName;

    @JsonProperty("storename")
    private  String storename;

    @JsonProperty("storeuuid")
    private  String storeuuid;

    private Long uuid;

    private String name;

    @JsonProperty("empuuid")
    private Long empUuid;

}
