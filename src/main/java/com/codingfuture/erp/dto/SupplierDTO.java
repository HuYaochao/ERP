package com.codingfuture.erp.dto;

import lombok.Data;

@Data
public class SupplierDTO {
    private Long uuid;
    private String name;
    private String address;
    private String contact;
    private String tele;
    private String email;
}
