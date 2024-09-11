package com.codingfuture.erp.web.controller;


import com.codingfuture.erp.dto.MenuDTO;
import com.codingfuture.erp.entity.Emp;
import com.codingfuture.erp.service.MenuService;
import com.codingfuture.erp.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
/**
 *
 * @author hyc
 * Date: 2024/8/31
 * @version 1.0
 */

@RestController
@RequestMapping("/v2/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/select")
    public Result<List<MenuDTO>> getMenuList(HttpSession session) {
        // 从会话中获取当前用户
        String username = ((Emp) session.getAttribute("currentUser")).getUsername();
        List<MenuDTO> menus = menuService.getMenusForUser(username);
        return Result.ok(menus);
    }
}


