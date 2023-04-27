package com.demo.component;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author 方锐
 * @since 2023/4/27 16:13
 */
@Component
public class CComponent {
    @PostConstruct
    public void postConstruct() {
        System.out.println("执行了 C 对象的 PostConstruct");
    }
    public void creating() {
        System.out.println("CComponent被创建");
    }
}
