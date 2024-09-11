package com.codingfuture.erp.service.impl;

import com.codingfuture.erp.entity.Emp;
import com.codingfuture.erp.mapper.EmpMapper;
import com.codingfuture.erp.service.EmpService;
import com.codingfuture.erp.util.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
/**
 *
 * @author hyc
 * Date: 2024/9/1
 * @version 1.0
 */



@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public Emp authenticate(String username, String password) {
        Emp emp = empMapper.findByUsername(username);
        if (emp != null && emp.getPassword().equals(password)) {
            return emp;
        }
        return null;
    }

    @Override
    public boolean updatePassword(Long empId, String oldPwd, String newPwd) {
        // 查询当前用户密码
        Emp emp = empMapper.findById(empId);
        if (emp == null || !emp.getPassword().equals(oldPwd)) {
            return false;
        }

        // 更新密码
        empMapper.updatePassword(empId, newPwd);
        return true;
    }

        public List<Emp> getEmpList() {
            return empMapper.getEmpList();
        }

    @Override
    public void registerUser(String username, String password) {
        String salt = PasswordUtils.generateSalt();
        try {
            String hashedPassword = PasswordUtils.hashPassword(password, salt);
            Emp emp = new Emp();
            emp.setUsername(username);
            emp.setPasswordHash(hashedPassword);
            emp.setSalt(salt);
            empMapper.insert(emp);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error while hashing password", e);
        }
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        Emp emp = empMapper.findByUsername(username);
        if (emp == null) {
            return false;
        }
        try {
            return PasswordUtils.verifyPassword(password, emp.getSalt(), emp.getPasswordHash());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error while verifying password", e);
        }
    }

    @Override
    public Emp findByUsername(String username) {
        return empMapper.findByUsername(username);
    }

}
