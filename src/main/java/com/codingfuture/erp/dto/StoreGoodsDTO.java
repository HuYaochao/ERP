package com.codingfuture.erp.dto;

import lombok.Data;

@Data
public class StoreGoodsDTO {
    private Long uuid;
    private String storeName;
    private String goodsName;
    private Integer num;
}
