package com.example.ssm_demo.mapper;

import com.example.ssm_demo.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 方锐
 * @since 2023/5/6 17:09
 */
@Mapper
public interface UserMapper {
    Userinfo getUserById(@Param("user_id") Integer id);
}
