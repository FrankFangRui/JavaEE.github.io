package com.demo.componet;

import com.demo.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author 方锐
 * @since 2023/4/23 21:03
 */
@Component
public class StudentBeans2 {
    // bean 注解是将方法返回的 对象 存储到Spring当中
//    @Bean(name = {"s3"})
//    public Student Student2() {
//        // 通常要查询数据库，这里写伪代码
//        Student stu = new Student();
//        stu.setId(1);
//        stu.setName("张三");
//        stu.setAge(18);
//        return stu;
//    }
}
