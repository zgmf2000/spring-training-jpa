package com.spring.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Autowired
	private EmployeeRepository repository;

	@Bean
	public CommandLineRunner printAll(ApplicationContext ctx)
	{
		return args -> {
			Employee newEmployee = new Employee("John", "Travis", "Male");
			repository.save(newEmployee);
			newEmployee = new Employee("Joan", "Travolta", "Female");
			repository.save(newEmployee);
		};
	}
}
