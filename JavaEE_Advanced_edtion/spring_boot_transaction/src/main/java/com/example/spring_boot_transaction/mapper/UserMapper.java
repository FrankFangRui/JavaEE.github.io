package com.example.spring_boot_transaction.mapper;

import com.example.spring_boot_transaction.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 方锐
 * @since 2023/5/21 14:50
 */
@Mapper
public interface UserMapper {

    int add(UserInfo userinfo);
}
