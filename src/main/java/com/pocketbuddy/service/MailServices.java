package com.pocketbuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServices {
	
	@Autowired
	
JavaMailSender mailSender;
	
	public void sendWelcomeMail(String email, String firstName) {
		String subject = "welcome to my team";
		String body = "Hey " + firstName +", we are exticed to have you on borad . if you have any question, feel free to reatch out -";
		String from = "mehulhome2@gmail.com";
		
		//logic
		
		SimpleMailMessage message =new SimpleMailMessage();
		
		message.setFrom(from);
		message.setTo(email);
		message.setSubject(subject);
		message.setText(body);
		
		mailSender.send(message);
				
	}

}
