package com.codingfuture.erp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MarketAddDTO {
    private Long uuid;
    private Date createtime;
    private String creatername;
    private Date endtime;
    private String endername;
    private Double totalmoney;
    private String state;

    private Long supplieruuid;
    private String suppliername;

    private List orderDetailList;
}
