package com.codingfuture.erp.web.controller;


import com.codingfuture.erp.entity.Role;
import com.codingfuture.erp.service.RoleManageService;
import com.codingfuture.erp.util.DataResult;
import com.codingfuture.erp.util.Result;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @Classname RoleController
 * @Description 角色管理
 * @Version 1.0.0
 * @Date 2024/9/9 9:27
 * @Created by Heyt
 */

@RestController
@RequestMapping("/v2")
public class RoleManageController {
    @Autowired
    private RoleManageService roleManageService;

    /**
     * @param pageNum
     * @param pageSize
     * @return :com.codingfuture.erp.util.Result<com.codingfuture.erp.util.DataResult<java.util.List<com.codingfuture.erp.entity.Role>>>
     * @Description: 查询
     * @Author: Heyt
     * @date: 2024/9/9 9:28
     */
    // role/listByPage
    @GetMapping("/role/listByPage")
    public Result<DataResult<List<Role>>> findListByPage(@RequestParam("page") Integer pageNum,
                                                         @RequestParam("rows") Integer pageSize) {
        Page<Role> page = PageHelper.startPage(pageNum, pageSize);
        roleManageService.findListByPage();
        DataResult<List<Role>> listDataResult = new DataResult<>(page.getResult(), page.getTotal());
        page.close();
        return Result.ok(listDataResult);
    }

    /**
     * @param id
     * @Description: 回显
     * @return: com.codingfuture.erp.util.Result<java.lang.Void>
     * @Author: Heyt
     * @date: 2024/9/9 9:47
     */
    // role/selectone
    @GetMapping("/role/selectone")
    public Result<DataResult<Role>> findById(Integer id) {
        DataResult<Role> supplierDataResult = new DataResult<>(roleManageService.findById(id), 1L);
        System.out.println(roleManageService.findById(id));
        return Result.ok(supplierDataResult);
    }

    /**
     * @param id
     * @Description: 删除
     * @return: com.codingfuture.erp.util.Result<java.lang.Void>
     * @Author: Heyt
     * @date: 2024/9/9 10:58
     */
    // role
    @DeleteMapping("/role")
    public Result<Void> deleteById(Integer id) {
        return roleManageService.deleteById(id) ? Result.ok("删除成功") : Result.ok("删除失败");
    }

    /**
     * @param role
     * @Description: 编辑
     * @return: com.codingfuture.erp.util.Result<java.lang.Void>
     * @Author: Heyt
     * @date: 2024/9/9 10:58
     */
    // role/update
    @PostMapping("/role/update")
    public Result<Void> updateById(Role role) {
        return roleManageService.updateById(role) ? Result.ok("更新成功") : Result.ok("更新失败");
    }

    /**
     * @param role
     * @Description: 新增
     * @return: com.codingfuture.erp.util.Result<java.lang.Void>
     * @Author: Heyt
     * @date: 2024/9/9 10:59
     */
    // role/add 
    @PostMapping("/role/add")
    public Result<Void> add(Role role) {
        Role byName = roleManageService.findByName(role.getName().replace(" ", ""));

        if (Objects.nonNull(byName)) {
            return Result.ok("添加失败，角色已存在");
        } else {
            return roleManageService.add(role) ? Result.ok("添加成功") : Result.ok("添加失败");
        }
    }

}
