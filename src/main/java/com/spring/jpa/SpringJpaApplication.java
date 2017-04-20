package com.spring.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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

	//Configure Global CORS
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				//Add a new map for each map you want to make CORS-able.
				registry.addMapping("employees/{empId}/experiment").allowedOrigins("http://localhost:4200");
			}
		};
	}
}
