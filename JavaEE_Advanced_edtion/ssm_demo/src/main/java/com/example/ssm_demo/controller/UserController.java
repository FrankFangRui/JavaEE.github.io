package com.example.ssm_demo.controller;

import com.example.ssm_demo.entity.Userinfo;
import com.example.ssm_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 方锐
 * @since 2023/5/7 15:05
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    // 当返回的是实体对象，hashmap 的时候，框架会自动将其转换成 JSON 对象
    // 网址中的URL都是小写，因为在windows上大小写不敏感，但是部署到Linux就是大小写敏感
    // 那如何区分单词？ 大多数公司使用中划线 get-user-by-id，小部分加_, 可以区分单词的时候，不加也可以
    @RequestMapping("/getuserbyid")
    public Userinfo getUserById(Integer id) {
        if(id == null) return null;
        return userService.getUserById(id);
    }
}
