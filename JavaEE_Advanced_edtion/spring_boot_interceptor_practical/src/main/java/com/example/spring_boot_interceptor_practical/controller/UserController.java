package com.example.spring_boot_interceptor_practical.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 方锐
 * @since 2023/5/17 12:48
 */
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public String login() {
        System.out.println("登录中");
        return "logging";
    }
}
