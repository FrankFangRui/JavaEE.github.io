package com.example.spring_aop_demo1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 方锐
 * @since 2023/5/15 20:15
 */
@RestController
@RequestMapping("/art")
public class ArticleController {

    @RequestMapping("/hi")
    public String sayHi(){
        return "hi, article.";
    }
}
