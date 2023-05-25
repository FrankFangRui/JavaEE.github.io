package com.example.spring_boot_transaction.service;

import com.example.spring_boot_transaction.entity.UserInfo;
import com.example.spring_boot_transaction.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @author 方锐
 * @since 2023/5/24 14:48
 */
@Service
public class LogService {

    @Transactional(propagation = Propagation.NESTED)
    public int add() {
        try {
            int num = 10/0;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return 1;
    }

/*    @Autowired
    private UserMapper userMapper;

    */
}
