package com.codingfuture.erp.service.impl;

import com.codingfuture.erp.dto.MenuDTO;
import com.codingfuture.erp.entity.Menu;
import com.codingfuture.erp.mapper.MenuMapper;
import com.codingfuture.erp.service.MenuService;
import com.codingfuture.erp.util.MenuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<MenuDTO> getMenusForUser(String username) {
        // 根据用户获取菜单
        List<Menu> menus = menuMapper.findMenusByUser(username);
        // 转换为 DTO 格式
        return MenuUtils.convertToDtoList(menus);
    }
}

