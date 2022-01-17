package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.restconsumer.Quote;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestConsumerApplication {
	private static final Logger log=LoggerFactory.getLogger(SpringRestConsumerApplication.class) ;
	public static void main(String[] args) {
		SpringApplication.run(SpringRestConsumerApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject(
					"https://reqres.in/api/unknown/", Quote.class);
			//https://andruxnet-random-famous-quotes.p.rapidapi.com/
			//https://quoters.apps.pcfone.io/api/random
			
			log.info(quote.toString());
		};
	}

}
