package com.demo.component;

import org.springframework.stereotype.Controller;

/**
 * @author 方锐
 * @since 2023/4/22 22:43
 */
@Controller
public class ArticleController {
    public String sayHello() {
        return "hello,controller";
    }
}
