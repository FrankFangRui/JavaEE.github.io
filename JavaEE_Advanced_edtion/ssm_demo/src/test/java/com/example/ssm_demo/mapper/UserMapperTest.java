package com.example.ssm_demo.mapper;


import com.example.ssm_demo.entity.Userinfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 方锐
 * @since 2023/5/7 16:43
 */
@SpringBootTest // 1.表明当前单元测试是运行在 SpringBoot 环境当中
class UserMapperTest {

    // 2.注入测试对象
    @Autowired //属性注入
    private UserMapper userMapper;

    @Test
    void getUserById() {
        // 3.添加单元测试的业务代码
        Userinfo userinfo = userMapper.getUserById(1);
        System.out.println(userinfo);
        Assertions.assertEquals(userinfo.getId(),1);
    }


    @Test
    void getAll() {
        List<Userinfo> list = userMapper.getAll();
        Assertions.assertEquals(1,list.size());
    }
}