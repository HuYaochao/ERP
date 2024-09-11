package com.codingfuture.erp.entity;


import lombok.Data;

import java.util.List;

/**
 *
 * @author hyc
 * Date: 2024/8/31
 * @version 1.0
 */

@Data
public class Menu {
    private String menuId;
    private String menuName;
    private String icon;
    private String url;
    private Integer pid;
    private List<Menu> list;
    private Boolean spread;
}
