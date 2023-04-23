package com.demo.componet;

import com.demo.model.Student;
import org.springframework.context.annotation.Bean;

/**
 * @author 方锐
 * @since 2023/4/23 21:03
 */
public class StudentBeans {
    // bean 注解是将方法返回的 对象 存储到Spring当中
    @Bean
    public Student student() {
        // 通常要查询数据库，这里写伪代码
        Student stu = new Student();
        stu.setId(1);
        stu.setName("李四");
        stu.setAge(18);
        return stu;
    }
}
