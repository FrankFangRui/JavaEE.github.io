package com.demo.componet;

import org.springframework.stereotype.Controller;

/**
 * @author 方锐
 * @since 2023/4/23 14:15
 */
@Controller
public class aController {
    public String sayHello() {
        return "hello,aController";
    }
}
