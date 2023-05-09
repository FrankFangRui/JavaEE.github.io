package com.example.ssm_demo.entity.viewobject;

import com.example.ssm_demo.entity.Articleinfo;
import lombok.Data;

/**
 * @author 方锐
 * @since 2023/5/9 20:35
 */
@Data
public class ArticleinfoVO /*extends Articleinfo */{ // 继承Articleinfo 相当于拥有全部的属性，但是有些用不到
    private String username; //添加一个额外属性
    private int id;
    private String title;
    private String content;
    private String createtime;
    private String updatetime;
    private int uid;
    private int rcount;
    private int state;
}
