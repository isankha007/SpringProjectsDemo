package com.sankha.springboot.sendemail.service;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
		
		MimeMessage mineMailMessage=javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		try {
			
			mimeMessageHelper=new MimeMessageHelper(mineMailMessage,true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(details.getRecipient());
			mimeMessageHelper.setText(details.getMsgBody());
			mimeMessageHelper.setSubject(details.getSubject());
			
			FileSystemResource file=new FileSystemResource
					(new File(details.getAttachment()));
			mimeMessageHelper.addAttachment(file.getFilename(), file);
			javaMailSender.send(mineMailMessage);
			
			return "Mail Sent successfully";
		}catch(Exception e) {
			return e.getMessage();
		}
		
		
	}

}
