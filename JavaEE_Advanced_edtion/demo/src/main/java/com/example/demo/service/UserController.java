package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 方锐
 * @since 2023/5/2 11:04
 */
@RequestMapping("/user")
@Controller
@ResponseBody
public class UserController {
    // 1.得到日志对象
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @RequestMapping("/hi")
    private String sayHi() {

        // 写日志
        logger.trace("我是 trace");
        logger.debug("我是 debugger");
        logger.info("我是 info");
        logger.warn("我是 warn");
        System.out.println("我是 println");
        logger.error("我是 error");
        return "Hi,Spring Boot.";
    }
}
