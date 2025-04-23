package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo", 
							"com.example.demo.controller", 
							"com.example.demo.dto", 
							"com.example.demo.logs", 
							"com.example.demo.model", 
							"com.example.demo.repository", 
							"com.example.demo.security", 
							"com.example.demo.service"})
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

}
