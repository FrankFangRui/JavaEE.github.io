package com.example.ssm_demo.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 方锐
 * @since 2023/5/6 16:49
 */
@Data
public class Userinfo {
    private int id;
    private String username;
    private String password;
    private String photo;
    private LocalDateTime createTime;//JDK8的功能
    private LocalDateTime updateTime;
    private int state;
}
