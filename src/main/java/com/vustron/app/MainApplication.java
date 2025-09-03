package com.vustron.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(MainApplication.class, args);

		FirstClass newFirstClass = ctx.getBean(FirstClass.class);
		System.out.println(newFirstClass.sayHello());
	}

	@Bean
	public FirstClass newFirstClass() {
		return new FirstClass();
	}

}
