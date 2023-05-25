package com.example.spring_boot_transaction.controller;

import com.example.spring_boot_transaction.entity.UserInfo;
import com.example.spring_boot_transaction.service.LogService;
import com.example.spring_boot_transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

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
    @Autowired
    private LogService logService;

    // 返回受影响的行数
    @RequestMapping("/add")
    public int add(UserInfo userinfo) {
        // 添加数据第一步要验证数据的合理
        if (userinfo == null || !StringUtils.hasLength(userinfo.getUsername())
                || !StringUtils.hasLength(userinfo.getPassword())) {
            return 0;
        }
        // 1.开始事务
        TransactionStatus transactionStatus =
                transactionManager.getTransaction(transactionDefinition);

        // 手动设置创建时间和修改时间的默认值
        userinfo.setCreatetime(LocalDateTime.now().toString());
        userinfo.setUpdatetime(LocalDateTime.now().toString());

        int result = userService.add(userinfo);
        System.out.println("添加： " + result);


        // 2.回滚事务
        // transactionManager.rollback(transactionStatus);

        // 3.提交事务
        transactionManager.commit(transactionStatus);

        return result;
    }

    @Transactional(propagation =  Propagation.NESTED)
    @RequestMapping("/insert")
    public Integer insert(UserInfo userInfo) {
        if (userInfo == null || !StringUtils.hasLength(userInfo.getUsername())
                || !StringUtils.hasLength(userInfo.getPassword())) {
            return 0;
        }
        // 添加用户
        int result = userService.add(userInfo);
        // 如果有返回结果，就记录日志
        if (result > 0) {
            // 日志
            try {
                logService.add();
            } catch (Exception e) {
                System.out.println("异常");
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        System.out.println("添加 insert： " + result);

        return result;
    }
}
