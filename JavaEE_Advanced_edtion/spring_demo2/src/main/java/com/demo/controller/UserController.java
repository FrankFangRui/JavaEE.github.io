package com.demo.controller;

import com.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author 方锐2
 * @since 2023/4/26 20:43
 */
@Controller
public class UserController {
    @Autowired
    private User user1;

    @
    public void getUser() {
        System.out.println("User1: " + user1);
    }
}
