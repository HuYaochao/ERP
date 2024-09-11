package com.codingfuture.erp.dto;

import lombok.Data;
/**
 *
 * @author hyc
 * Date: 2024/9/1
 * @version 1.0
 */

@Data
public class LoginDTO {
    private Long uuid;
    private String username;
    private String pwd;
}
