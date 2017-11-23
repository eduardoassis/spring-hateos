package com.learn.hateoas.springhateos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.learn.hateoas.springhateos" })
public class SpringHateosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHateosApplication.class, args);
	}
}
