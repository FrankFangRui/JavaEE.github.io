package com.example.spring_mvc_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 方锐
 * @since 2023/5/4 22:45
 */
@Controller
@ResponseBody
public class CalcController {
    @RequestMapping("/calc")// 和form表单中的 action 对应起来
    public String calc(Integer num1,Integer num2) {
        return "sum: " + (num1+num2);
    }
}
