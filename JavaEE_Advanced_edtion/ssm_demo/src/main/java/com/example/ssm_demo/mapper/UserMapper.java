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
     * 通过 id 来获取 用户名
     * @param username
     * @return
     */
    Userinfo getIdByName(@Param("username") String username);

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

    /**
     * 添加用户并返回用户 id
     * @param userinfo
     * @return
     */
    int addGetId(Userinfo userinfo);

    /**
     * 修改用户
     * @param userinfo
     * @return
     */
    int upUserName(Userinfo userinfo);

    /**
     * 根据用户 id 删除用户信息
     * @param id
     * @return
     */
    int delById(@Param("id") Integer id);

    List<Userinfo> getListByOrder(@Param("order") String order);

    Userinfo login(@Param("username") String username,@Param("password") String password);

    List<Userinfo> getListByName(@Param("username")String username);
}
