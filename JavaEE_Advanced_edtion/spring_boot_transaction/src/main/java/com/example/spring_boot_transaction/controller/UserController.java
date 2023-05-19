package com.example.spring_boot_transaction.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 方锐
 * @since 2023/5/19 20:38
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/add")
    public int add(){

    }
}
