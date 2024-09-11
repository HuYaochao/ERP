package com.codingfuture.erp.service.impl;

import com.codingfuture.erp.entity.Role;
import com.codingfuture.erp.mapper.RoleManageMapper;
import com.codingfuture.erp.service.RoleManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname RoleServiceImpl
 * @Version 1.0.0
 * @Date 2024/9/9 9:36
 * @Created by Heyt
 */
@Service
public class RoleManageServiceImpl implements RoleManageService {
    @Autowired
    private RoleManageMapper roleManageMapper;

    @Override
    public List<Role> findListByPage() {
        return roleManageMapper.findListByPage();
    }

    @Override
    public Role findById(Integer id) {
        return roleManageMapper.findById(id);
    }

    @Override
    public boolean deleteById(Integer id) {
        return roleManageMapper.deleteById(id);
    }

    @Override
    public Role findByName(String name) {
        return roleManageMapper.findByName(name);
    }

    @Override
    public boolean updateById(Role role) {
        return roleManageMapper.updateById(role);
    }

    @Override
    public boolean add(Role role) {
        return roleManageMapper.add(role);
    }
}
