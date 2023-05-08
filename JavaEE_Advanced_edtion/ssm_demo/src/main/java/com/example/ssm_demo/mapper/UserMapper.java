package com.example.ssm_demo.mapper;

import com.example.ssm_demo.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 方锐
 * @since 2023/5/6 17:09
 */
@Mapper
public interface UserMapper {
    // 在实现方面，会有一个 代理 实现这个接口 然后 调用 .xml 中的数据

    /**
     *  根据用户 id 查询用户信息
     * @param userId
     * @return
     */
    Userinfo getUserById(@Param("userId") Integer userId);

    /**
     * 查询全部
     * @return
     */
    List<Userinfo> getAll();// 当xml中没有实现就会报错

    /**
     * 添加用户对象
     * @param userinfo
     * @return
     */
    int add(Userinfo userinfo);
}
