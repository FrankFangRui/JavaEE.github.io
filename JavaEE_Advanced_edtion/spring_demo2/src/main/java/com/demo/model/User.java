package com.demo.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 方锐
 * @since 2023/4/26 19:33
 */
@Data
public class User {
    private int id;
    private String name;
    private String password;
}
