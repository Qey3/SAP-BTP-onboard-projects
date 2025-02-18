package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyTenantApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyTenantApplication.class, args);
		System.out.println("Hello MultiTenant!");
	}

}
