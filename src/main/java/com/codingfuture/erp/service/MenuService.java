package com.codingfuture.erp.service;

import com.codingfuture.erp.dto.MenuDTO;

import java.util.List;

public interface MenuService {
    List<MenuDTO> getMenusForUser(String username);

}

