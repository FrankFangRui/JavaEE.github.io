package com.example.spring_boot_interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author 方锐
 * @since 2023/5/16 11:36
 */
@RestController
@RequestMapping("/user")
public class UserController {

//    @GetMapping
//    public String getMethod(){
//        return "执行 GET 请求方式";
//    }
//
//    @PostMapping
//    public String postMethod(){
//        return "执行 POST 请求方式";
//    }
    @RequestMapping("/getnum")
    public Integer getNumber() {
        return new Random().nextInt(10);
    }

    @RequestMapping("/getuser")
    public String getUser() {
        System.out.println("执行了 get User");
        return "get user";
    }

    @RequestMapping("/login")
    public String login() {
        Object obj = null;
        obj.hashCode();
        System.out.println("执行了 get User ");
        return "get login";
    }

    @RequestMapping("/reg")
    public String reg() {
        int i = 0 / 10;
        System.out.println("执行了 reg");
        return "reg";
    }

}
