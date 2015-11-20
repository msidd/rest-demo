package com.github.msidd.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource ("classpath:securityContext.xml")
public class SpringDataRestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRestDemoApplication.class, args);
    }
}
