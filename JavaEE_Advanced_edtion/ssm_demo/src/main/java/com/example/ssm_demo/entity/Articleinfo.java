package com.example.ssm_demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 方锐
 * @since 2023/5/9 20:32
 */
@Data
public class Articleinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String title;
    private String content;
    private String createtime;
    private String updatetime;
    private int uid;
    private int rcount;
    private int state;
}
