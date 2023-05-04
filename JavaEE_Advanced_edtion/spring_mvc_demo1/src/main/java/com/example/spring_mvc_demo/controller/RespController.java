package com.example.spring_mvc_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 方锐
 * @since 2023/5/4 22:34
 */
@Controller
@RequestMapping("/resp")
@ResponseBody
public class RespController {
    @RequestMapping("/hi")
    public String sayHi() {
        return "/index.html";
    }
}
