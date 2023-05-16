package com.example.spring_aop_demo1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 方锐
 * @since 2023/5/15 20:00
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/hi")
    public String sayHi(String name){
        System.out.println("执行了sayHi方法");
        return "Hi," + name;
    }

    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello, world.";
    }
}
