package com.demo.service;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author 方锐
 * @since 2023/4/24 10:35
 */
@Service
public class StudentService {
    public void sayHi() {
        System.out.println("Hi,Service");
    }
}
