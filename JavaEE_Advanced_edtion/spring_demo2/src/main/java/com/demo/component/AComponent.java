package com.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author 方锐
 * @since 2023/4/27 16:12
 */
@Component
public class AComponent {
    @PostConstruct
    public void postConstruct() {
        bComponent.creating();
        System.out.println("执行了 A 对象的 PostConstruct ");
    }

    @Autowired
    private BComponent bComponent;


}
