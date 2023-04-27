package com.demo.component;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author 方锐
 * @since 2023/4/27 14:35
 */
//@Component
public class BeanLifeComponent implements BeanNameAware {
    @Override
    public void setBeanName(String s) {
        System.out.println("执行了通知");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("执行了 @PostConstruct");
    }

    public void init() {
        System.out.println("执行了 int-method 方法");
    }

    @PreDestroy
    public void preDestory() {
        System.out.println("销毁之前执行了销毁方法");
    }
}
