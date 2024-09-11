package com.codingfuture.erp.service;

import com.codingfuture.erp.entity.Emp;


import java.util.List;
/**
 *
 * @author hyc
 * Date: 2024/9/1
 * @version 1.0
 */

public interface EmpService {
    Emp authenticate(String username, String password);
    boolean updatePassword(Long empId, String oldPwd, String newPwd);

    /**
     * 查询员工列表
     * @return List
     */
    List<Emp> getEmpList();

    void registerUser(String username, String password);

    boolean authenticateUser(String username, String password);

    Emp findByUsername(String username);
}
