package com.sankha.springboot.sendemail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sankha.springboot.sendemail.entity.EmailDetails;

@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	
	//@Value("$(spring.mail.username)")
	@Value("${spring.mail.username}")
	private String sender;

	@Override
	public String sendSimpleMail(EmailDetails details) {
		// TODO Auto-generated method stub
		try {
			SimpleMailMessage mailMessage= new SimpleMailMessage();
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getRecipient());
			mailMessage.setText(details.getMsgBody());
			mailMessage.setSubject(details.getSubject());
			javaMailSender.send(mailMessage);
			return "Mail Sent successfully";
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
	}

	@Override
	public String sendWithAttachment(EmailDetails details) {
		// TODO Auto-generated method stub
		
		SimpleMailMessage mailMessage= new SimpleMailMessage();
		mailMessage.setFrom(sender);
		mailMessage.setTo(details.getRecipient());
		mailMessage.setText(details.getMsgBody());
		mailMessage.setSubject(details.getSubject());
		javaMailSender.send(mailMessage);
		return "Mail Sent successfully";
	}

}
