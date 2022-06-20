package com.sankha.springboot.crud;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sankha.springboot.crud.entity.Product;
import com.sankha.springboot.crud.repository.ProductRepository;

@SpringBootApplication
public class SpringBootTestIntegrationApplication {

	@Autowired
    private ProductRepository repository;

    @PostConstruct
    public void init() {
//        repository.saveAll(
//                Stream.of( new Product("Book", 1, 299),
//                           new Product("mobile", 1, 39999))
//                        .collect(Collectors.toList())
//        );
    }
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestIntegrationApplication.class, args);
	}

}
