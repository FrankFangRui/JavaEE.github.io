package com.demo.controller;

import com.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 方锐
 * @since 2023/4/28 9:37
 */
@Component
public class AStudentController {
    @Autowired
    Student student;
    public Student getStudent() {
        student.setName("张三");
        return student;
    }
}
