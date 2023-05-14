package com.demo.controller;

import com.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

/**
 * @author 李四
 * @since 2023/4/26 20:43
 */
@Controller //Controller 控制用户的行为，表示要获取对象
public class UserController {
    @Autowired
    private User user1;


    public void getUser() {
        System.out.println("User1: " + user1);
        User u = user1;
        //user1赋值给 u，通过u修改属性，也会影响user1中的属性·
        u.setName("李四");
        System.out.println("u: " + u);
    }
}
