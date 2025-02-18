package com.example.java_tutorial;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class HelloWorldLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldLogApplication.class, args);
        log.info("Hello World!");
    }

}
