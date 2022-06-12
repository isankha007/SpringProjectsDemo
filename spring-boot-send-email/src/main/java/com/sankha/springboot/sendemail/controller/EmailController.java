package com.sankha.springboot.sendemail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sankha.springboot.sendemail.entity.EmailDetails;
import com.sankha.springboot.sendemail.service.EmailService;

@RestController
public class EmailController {
	
	 @Autowired
	 private EmailService emailService;
	 
	 @PostMapping("/sendMail")
	 public String sendMail(@RequestBody EmailDetails details) {
		 try {
			String status= emailService.sendSimpleMail(details);
			 return status;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	 }

	 @PostMapping("/sendMailWithAttachment")
	 public String sendMailWithAttachment(@RequestBody EmailDetails details) {
		 String status= emailService.sendSimpleMail(details);
		 return status;
	 }
}
