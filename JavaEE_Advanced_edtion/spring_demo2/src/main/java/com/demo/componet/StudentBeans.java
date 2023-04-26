package com.demo.componet;

import com.demo.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author 方锐
 * @since 2023/4/23 21:03
 */
@Component
public class StudentBeans { // 存放的是 Bean 对象
    // bean 注解是将方法返回的 对象 存储到Spring当中
//    @Bean(name = {"s1","s2"})
//    public Student student() {
//        // 通常要查询数据库，这里写伪代码
//        Student stu = new Student();
//        stu.setId(1);
//        stu.setName("王五");
//        stu.setAge(18);
//        return stu;
//    }

    @Bean //@Resource(name = "student2") 匹配的是方法名
    public Student student1() {
        Student student = new Student();
        student.setId(1);
        student.setName("李四");
        student.setAge(18);
        return student;
    }
    @Bean
    public Student student2() {
        Student student = new Student();
        student.setId(2);
        student.setName("王五");
        student.setAge(18);
        return student;
    }
}
