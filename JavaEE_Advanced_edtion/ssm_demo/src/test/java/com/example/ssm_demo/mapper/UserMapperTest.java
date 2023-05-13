package com.example.ssm_demo.mapper;


import com.example.ssm_demo.entity.Userinfo;
import org.apache.catalina.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @Test
    void add() {
        // 伪代码，构建对象并设置响应的值
        // userinfo 是由前端传递过来的
        Userinfo userinfo = new Userinfo();
        //userinfo.setUsername("王五");
        userinfo.setPassword("123123");
        userinfo.setCreatetime(LocalDateTime.now());
        userinfo.setUpdatetime(LocalDateTime.now());
        // 调用 mybatis 添加方法
        int result = userMapper.addGetId(userinfo);
        System.out.println("添加：" + result);

        int uid = userinfo.getId();
        System.out.println("用户Id:" + uid);

        Assertions.assertEquals(1,result);
    }

    @Test
    void upUserName() {
        // 构建测试数据
        Userinfo userinfo = new Userinfo();
        userinfo.setId(5);
        //userinfo.setUsername("十王");
        int result = userMapper.upUserName(userinfo);
        System.out.println("修改:" + result);
        Assertions.assertEquals(1,result);// 表明 修改了 1 条 数据
    }

    @Test
    @Transactional
    void delById() {
        int result = userMapper.delById(1);
        System.out.println("修改:" + result);
        Assertions.assertEquals(1,result);
    }

    @Test
    void getNameById() {
        Userinfo userinfo = userMapper.getIdByName("张三");
        System.out.println(userinfo.getId());
    }

    @Test
    void getListByOrder() {
        List<Userinfo> list = userMapper.getListByOrder("asc");
        System.out.println(list);
    }

    @Test
    void login() {
        String username = "admin";
        String password = "' or 1='1";
        Userinfo userinfo = userMapper.login(username,password);
        System.out.println("登录状态：" + (userinfo == null ? "失败" : "成功"));
    }

    @Test
    void getListByName() {
        String username = "m";
        List<Userinfo> list = userMapper.getListByName(username);
        System.out.println("list:" + list);
    }

    @Test
    void add2() {
        Userinfo userinfo = new Userinfo();
        userinfo.setUsername("张三");
        userinfo.setPhoto(null);
        userinfo.setPassword("123");
        int result = userMapper.add2(userinfo);
        System.out.println("添加:" + result);
    }

    @Test
    void add3() {
        Userinfo userinfo = new Userinfo();
        userinfo.setUsername("李四");
        userinfo.setPhoto("picture.png");
        userinfo.setPassword("123");
        int result = userMapper.add3(userinfo);
        System.out.println("添加:" + result);
    }

    @Test
    void getListByParam() {
        List<Userinfo> list = userMapper.getListByParam(null,null);
        System.out.println(list);
    }

    @Test
    void update2() {
        Userinfo user = new Userinfo();
        user.setId(6);
        user.setUsername(null);
        user.setPhoto("top.png");
        user.setPassword("123");
        int result = userMapper.update2(user);
        System.out.println("修改：" + result);
    }

    @Test
    void dels() {

        List<Integer> ids = new ArrayList<>();
        ids.add(4);
        ids.add(5);
        ids.add(6);
        int result = userMapper.dels(ids);
        System.out.println("删除：" + result);
    }
}