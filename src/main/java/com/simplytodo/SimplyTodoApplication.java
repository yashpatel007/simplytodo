package com.simplytodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.simplytodo")
public class SimplyTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimplyTodoApplication.class, args);
	}

}
