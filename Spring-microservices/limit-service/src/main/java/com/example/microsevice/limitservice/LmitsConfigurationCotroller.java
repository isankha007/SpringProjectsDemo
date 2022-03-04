package com.example.microsevice.limitservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microsevice.limitservice.bean.LimitConfiguration;
import com.example.microsevice.limitservice.confifuration.Configuration;

@RestController
public class LmitsConfigurationCotroller {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public LimitConfiguration retriveLimitsFromConfiguration() {
		return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
		
	}

}
