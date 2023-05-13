package com.example.ssm_demo.entity.viewobject;

import com.example.ssm_demo.entity.Articleinfo;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 方锐
 * @since 2023/5/9 20:35
 */
@Data// 不实现 Serializable 这个接口，在序列化的时候就会可能报错
public class ArticleinfoVO extends Articleinfo implements Serializable { // 继承Articleinfo 相当于拥有全部的属性，但是有些用不到

    private static final long serialVersionUID = 1L;
    private String username; //添加一个额外属性
    public String toString() {
        return "username:" + username + " " + super.toString();
    }
//    private int id;
//    private String title;
//    private String content;
//    private String createtime;
//    private String updatetime;
//    private int uid;
//    private int rcount;
//    private int state;
}
