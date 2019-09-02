package com.sgic.mail.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.mail.entities.User;
import com.sgic.mail.service.NotificationService;

@RestController
public class RegistrationController {
	
	private Logger logger = LoggerFactory.getLogger(RegistrationController.class);

	@SuppressWarnings("unused")
	@Autowired
	private NotificationService notificationService;
	
	@RequestMapping("/signup")
	public String Signup() {
		return "Please Signup for our Service.";
	}
	
	@RequestMapping("/signup-success")
	public String SignupSuccess() {
		
		//Create User
		
		User user = new User();
		user.setFirstName("Keerthi");
		user.setLastName("Ravi");
		user.setEmailAddress("geerthi@clecares.org");
		
		//Send a Notification
		try {
			notificationService.sendNotofication(user);
		} catch (MailException e) {
			// Catch error
			logger.info("Error Sending Mail:"+ e.getMessage());
		}
		
		return "Thank you for Registering with us.";
		
	}
	
}
