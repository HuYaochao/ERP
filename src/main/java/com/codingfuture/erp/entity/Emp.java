package com.codingfuture.erp.entity;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author hyc
 * Date: 2024/9/1
 * @version 1.0
 */

@Data
public class Emp {
    private Long uuid;
    private String username;
    private String password;
    private String name;
    private Long gender;
    private String email;
    private String telephone;
    private String address;
    private Date birthday;
    private Long depUuid;

    private String passwordHash; // 存储加密后的密码
    private String salt; // 存储盐值
}
