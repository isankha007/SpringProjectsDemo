package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class TaskManagerSpringMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerSpringMavenApplication.class, args);
	}
	
	@Bean
    @Scope("singleton")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
