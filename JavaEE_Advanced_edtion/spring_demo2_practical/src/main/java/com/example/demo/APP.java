package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 方锐
 * @since 2023/5/13 21:46
 */
public class APP {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
        User user = (User)context.getBean("user");
        user.init();
    }

}
