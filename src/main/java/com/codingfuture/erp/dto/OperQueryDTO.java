package com.codingfuture.erp.dto;

import lombok.Data;

@Data
public class OperQueryDTO {
   private Integer page;
   private Integer rows;
   private Long empuuid;
   private String opertime;
   private String topertime;
   private Long storeuuid;
   private Long goodsuuid;
   private String type;
}

