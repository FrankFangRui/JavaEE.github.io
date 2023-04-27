package com.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author 方锐
 * @since 2023/4/27 16:13
 */
@Component
public class BComponent {


    @PostConstruct
    public void postConstruct() {
        ccomponent.creating();
        System.out.println("执行了 B 对象的 PostConstruct");
    }

    public void creating() {
        System.out.println("BComponent被创建");
    }

    @Autowired
    private CComponent ccomponent;
}
