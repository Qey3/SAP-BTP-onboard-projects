package com.example.destination2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PasswordDestinationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasswordDestinationApplication.class, args);
		System.out.println("second destination has started");
	}

}
