package com.example.demo;

import lombok.Data;
import lombok.NonNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 方锐
 * @since 2023/4/29 19:41
 */
@Component // 加了Component 就能在项目启动的时候跟着启动，赋值属性
@ConfigurationProperties("student")//读取 yml 文件中的对象
@Data
public class Student {
    private int id;
    @NonNull
    private String name;
    private int age;

    public static void main(String[] args) {
        Student s2 = new Student("张三");
        s2.setId(1);
        System.out.println(s2);
    }

}
