package com.demo.componet;

import com.demo.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author 方锐
 * @since 2023/4/26 19:33
 */
@Component
public class UserBeans {

    @Bean
    public User user1 () {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        return null;
    }
}
