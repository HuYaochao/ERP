package com.codingfuture.erp.service;

import com.codingfuture.erp.entity.Role;

import java.util.List;

/**
 * @Classname RoleService
 * @Version 1.0.0
 * @Date 2024/9/9 9:34
 * @Created by Heyt
 */
public interface RoleManageService {
    List<Role> findListByPage();

    Role findById(Integer id);

    boolean deleteById(Integer id);

    Role findByName(String name);

    boolean updateById(Role role);

    boolean add(Role role);
}
