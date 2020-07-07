package com.dyz.spring_boot_acivemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringBootAcivemqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAcivemqApplication.class, args);
    }

}
