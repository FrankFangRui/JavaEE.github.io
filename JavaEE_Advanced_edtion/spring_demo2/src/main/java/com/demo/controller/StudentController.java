package com.demo.controller;

import com.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author 方锐
 * @since 2023/4/24 10:35
 */
@Controller
public class StudentController {
    @Autowired
    @Qualifier("student1")
    private Student student;

    public void sayHi() {
        System.out.println(student.toString());
    }

}
// 1. 使用属性注入的方式获取 Bean
// 不需要去 new
/*
 * 这里就有控制反转的思想（Ioc） 通过容器赋值而不是自己创建对象*/
//@Autowired
//private StudentService studentService;

// Spring到容器中去找这个变量然后赋值



//private final int num;
// 程序自己赋值
//    public StudentController() {
//        this.num = 10;
//    }
// 2.setter 注入，通过 setter 方法来赋值，给 setter 方法加 @Autowired ，Autowired就是自动赋值，Spring把值传输过来


//    @Autowired
//    public void setStudentService(StudentService studentService) {
//        this.studentService = studentService;
//    }



// 3.构造方法注入

//private final StudentService studentService;

//    @Autowired
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }
//@Resource(name = "student1")// 告诉Spring获取对象的名字