package com.codingfuture.erp.mapper;

import com.codingfuture.erp.entity.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *
 * @author hyc
 * Date: 2024/9/1
 * @version 1.0
 */

@Mapper
public interface EmpMapper {

    Emp findByUsername(String username);

    Emp findById(Long empId);

    void updatePassword(@Param("empId") Long empId, @Param("newPwd") String newPwd);

    List<Emp> getEmpList();

    @Insert("INSERT INTO emp (username, password_hash, salt) VALUES (#{username}, #{passwordHash}, #{salt})")
    void insert(Emp emp);
}
