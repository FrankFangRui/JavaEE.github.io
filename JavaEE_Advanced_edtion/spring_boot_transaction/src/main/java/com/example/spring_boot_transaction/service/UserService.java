package com.example.spring_boot_transaction.service;

import com.example.spring_boot_transaction.entity.UserInfo;
import com.example.spring_boot_transaction.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 方锐
 * @since 2023/5/21 15:57
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    public Integer add(UserInfo userinfo) {
        int result =  userMapper.add(userinfo);
        System.out.println("用户添加：" + result);
        return result;
    }
}
