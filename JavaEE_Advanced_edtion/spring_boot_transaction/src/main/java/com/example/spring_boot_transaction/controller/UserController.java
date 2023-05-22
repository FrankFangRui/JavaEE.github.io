package com.example.spring_boot_transaction.controller;

import com.example.spring_boot_transaction.entity.Userinfo;
import com.example.spring_boot_transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 方锐
 * @since 2023/5/19 20:38
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private DataSourceTransactionManager transactionManager;
    @Autowired
    private TransactionDefinition transactionDefinition;

    // 返回受影响的行数
    @RequestMapping("/add")
    public int add(Userinfo userinfo){
        // 添加数据第一步要验证数据的合理
        if(userinfo == null || !StringUtils.hasLength(userinfo.getUsername())
        || !StringUtils.hasLength(userinfo.getPassword())) {
            return 0;
        }
        int result = userService.add(userinfo);
        System.out.println("添加： " + result);
        return result;
}
