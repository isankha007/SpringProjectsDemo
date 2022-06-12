package com.sankha.springboot.sendemail.service;

import com.sankha.springboot.sendemail.entity.EmailDetails;

public interface EmailService {
	String sendSimpleMail(EmailDetails details);
	String sendWithAttachment(EmailDetails details);
}
