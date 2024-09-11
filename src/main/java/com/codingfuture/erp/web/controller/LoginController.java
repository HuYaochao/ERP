package com.codingfuture.erp.web.controller;

import com.codingfuture.erp.dto.LoginDTO;
import com.codingfuture.erp.entity.Emp;
import com.codingfuture.erp.service.EmpService;
import com.codingfuture.erp.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/v2")
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@ModelAttribute LoginDTO loginDTO, HttpSession session) {
        Emp emp = empService.authenticate(loginDTO.getUsername(), loginDTO.getPwd());
        if (emp != null) {
            // 保存用户信息到session中
            session.setAttribute("currentUser", emp);
            session.setAttribute("username",emp.getName());
            return Result.ok("Login successful").redirect("/index.html");
        } else {
            return Result.err("Invalid username or password");
        }
    }


    /**
     * 处理登录请求，支持接收LoginDTO对象并处理会话管理
     */
//    @PostMapping("/login")
//    public Result login(@ModelAttribute LoginDTO loginDTO, HttpSession session) {
//        // 调用服务层验证用户名和密码
//        boolean isAuthenticated = empService.authenticateUser(loginDTO.getUsername(), loginDTO.getPwd());
//
//        if (isAuthenticated) {
//            // 验证通过，获取用户信息
//            Emp emp = empService.findByUsername(loginDTO.getUsername());
//
//            // 将用户信息保存到 session
//            session.setAttribute("currentUser", emp);
//            session.setAttribute("username", emp.getName());
//
//            // 返回登录成功，并跳转到首页
//            return Result.ok("Login successful").redirect("/index.html");
//        } else {
//            // 登录失败，返回错误信息
//            return Result.err("Invalid username or password");
//        }
//    }


    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        empService.registerUser(username, password);
        return "User registered successfully";
    }

    @PostMapping("/login_showName")
    public Result<Object> loginShowName(HttpSession session) {
        Emp currentUser = (Emp) session.getAttribute("currentUser");
        if (currentUser != null) {
            return Result.ok().rows(currentUser.getName()).msg("success");
        } else {
            return Result.err("User not logged in").code(401);
        }
    }

    @GetMapping("//login_loginOut")
    public Result<Object> logout(HttpServletRequest request) {
        // 获取当前会话
        HttpSession session = request.getSession(false);
        if (session != null) {
            // 使当前会话无效
            session.invalidate();
        }
        // 返回成功的 Result 对象
        return Result.ok();
    }


}