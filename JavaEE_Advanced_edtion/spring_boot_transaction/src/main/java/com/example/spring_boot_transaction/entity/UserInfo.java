package com.example.spring_boot_transaction.entity;

import lombok.Data;

/**
 * @author 方锐
 * @since 2023/5/21 14:43
 */
@Data
public class UserInfo {
    private Integer id;
    private String username;
    private String password;
    private String photo;
    private String createtime;
    private String updatetime;
    private Integer state;
}
