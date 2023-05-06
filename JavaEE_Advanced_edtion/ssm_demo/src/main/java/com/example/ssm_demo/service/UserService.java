package com.example.ssm_demo.service;

import com.example.ssm_demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 方锐
 * @since 2023/5/6 21:29
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

}
