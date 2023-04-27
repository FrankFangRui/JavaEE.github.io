package com;

import com.demo.component.AComponent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 方锐
 * @since 2023/4/27 16:17
 */
public class App3 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
        AComponent ac = context.getBean("AComponent", AComponent.class);
    }
}
