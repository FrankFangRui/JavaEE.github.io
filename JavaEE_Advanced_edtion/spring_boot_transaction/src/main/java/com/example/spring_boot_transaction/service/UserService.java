package com.example.spring_boot_transaction.service;

import com.example.spring_boot_transaction.entity.Userinfo;
import com.example.spring_boot_transaction.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 方锐
 * @since 2023/5/21 15:57
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public Integer add(Userinfo userinfo) {
        return userMapper.add(userinfo);
    }
}
