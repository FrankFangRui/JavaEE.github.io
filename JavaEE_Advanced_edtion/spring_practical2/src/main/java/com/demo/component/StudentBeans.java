package com.demo.component;


import com.demo.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author 方锐
 * @since 2023/4/28 9:15
 */
@Component
public class StudentBeans {
    @Scope("prototype")
    @Bean
    public Student student2() {
        Student student = new Student();
        student.setName("方锐");
        student.setSex("男");
        student.setId(2);
        return student;
    }
}
