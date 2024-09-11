package com.codingfuture.erp.dto;

import lombok.Data;

@Data
public class AddInventoryQueryDTO {
    private Long goodsuuid;
    private Long storeuuid;
    private Long num;
    private String type;
    private String remark;
    private Long uuid;

}
