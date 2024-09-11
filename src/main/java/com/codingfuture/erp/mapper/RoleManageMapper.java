package com.codingfuture.erp.mapper;

import com.codingfuture.erp.entity.Role;

import java.util.List;

/**
 * @Classname RoleMapper
 * @Version 1.0.0
 * @Date 2024/9/9 9:36
 * @Created by Heyt
 */
public interface RoleManageMapper {
    List<Role> findListByPage();

    Role findById(Integer id);

    boolean deleteById(Integer id);

    Role findByName(String name);

    boolean add(Role role);

    boolean updateById(Role role);
}
