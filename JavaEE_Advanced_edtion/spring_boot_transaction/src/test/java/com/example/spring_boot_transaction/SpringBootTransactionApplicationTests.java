package com.example.spring_boot_transaction;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class SpringBootTransactionApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().toString());
    }

}
