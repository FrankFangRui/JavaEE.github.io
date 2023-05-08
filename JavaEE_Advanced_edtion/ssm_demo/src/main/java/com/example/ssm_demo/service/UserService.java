package com.example.ssm_demo.service;

import com.example.ssm_demo.entity.Userinfo;
import com.example.ssm_demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 方锐
 * @since 2023/5/6 21:29
 */
@Service
public class UserService {

    // Service要依赖 Mapper 属性注入赋值
    // UserMapper 是一个接口，仍然可以调用方法
    @Autowired //Spring的注解 import org.springframework.beans.factory.annotation.Autowired;
    private UserMapper userMapper;
    // 可以注入一个 new 的对象，在Spring容器中找这个属性并注入
    // 当这个要注入的对象是一个接口，Spring会去找接口的实现类并且注入，当一个接口有两个实现类的时候，就无法选择，会报错

    // 这里的方法名和 UserMapper 中可以不一样，但最好一样
    public Userinfo getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

}
