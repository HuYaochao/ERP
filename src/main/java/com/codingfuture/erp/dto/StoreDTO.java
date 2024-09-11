package com.codingfuture.erp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTO {
    private Long uuid;
    private String name;
    private Integer empuuid;
}
