package com.example.Authentication.and.Authorization.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(com.example.Authentication.and.Authorization.application.Application.class, args);
	}

}