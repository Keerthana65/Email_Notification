package com.sgic.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sgic.mail.entities.User;

@Service
public class NotificationService {

	@SuppressWarnings("unused")
	private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendNotofication(User user) throws MailException {
		
		//Send Mail
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmailAddress());
		mail.setFrom("geerthana65@gmail.com");
		mail.setSubject("Hello Kitty");
		mail.setText("This is a cool email notification");
		
		javaMailSender.send(mail);
	}
}
