package com.sankha.rest.webservices.restfulWebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

//controller
@RestController
public class HelloWorldWController {
	
	//GET
	//URI
	//Method
	//@RequestMapping(method=RequestMethod.GET,path="/hello-world")
	@Autowired
	private MessageSource messagesource;
	
	
	@GetMapping(path="/hello-world")
	public String helloWord() {
		return "Hello World";
	}
	//hello world bean
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWordBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWordPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World %s", name));
	}
	
	@GetMapping(path="/hello-world-Internationalized")
	public String helloWordInternationalized(
			//@RequestHeader(name="Accept-Language",required = false) Locale locale
			) {
		return messagesource
				.getMessage("good.morning.message",null,"Default Message",LocaleContextHolder.getLocale());
	}

}
