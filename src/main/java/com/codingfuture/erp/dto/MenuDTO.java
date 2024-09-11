package com.codingfuture.erp.dto;

import lombok.Data;

import java.util.List;

/**
 *
 * @author hyc
 * Date: 2024/8/31
 * @version 1.0
 */

@Data
public class MenuDTO {
    private String menuId;
    private String name;
    private String title;
    private String icon;
    private String jump;
    private Integer pid;
    private Boolean spread;
    private List<MenuDTO> list;
}
