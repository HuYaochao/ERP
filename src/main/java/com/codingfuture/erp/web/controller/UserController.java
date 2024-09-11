package com.codingfuture.erp.web.controller;

import com.codingfuture.erp.entity.Emp;
import com.codingfuture.erp.service.EmpService;
import com.codingfuture.erp.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/v2")
public class UserController {

    @Autowired
    private EmpService empService;

    @PostMapping("/updatepwd")
    public Result updatePassword(@RequestParam String oldPwd, @RequestParam String newPwd, HttpSession session) {
        // 获取当前登录用户
        Emp currentUser = (Emp) session.getAttribute("currentUser");

        if (currentUser == null) {
            return Result.err("用户未登录");
        }

        // 调用Service进行密码更新
        boolean updateSuccess = empService.updatePassword(currentUser.getUuid(), oldPwd, newPwd);

        if (updateSuccess) {
            return Result.ok();
        } else {
            return Result.err("密码更新失败，请检查旧密码是否正确");
        }
    }
}