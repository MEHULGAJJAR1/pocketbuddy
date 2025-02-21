package com.pocketbuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.pocketbuddy.entity.UserEntity;

import com.pocketbuddy.repository.UserRepository;
import com.pocketbuddy.service.MailServices;

@Controller
public class SessionController {
	
	
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	MailServices serviceMail;
	
	@Autowired
	UserRepository repositoryUser;

	@GetMapping(value = {"/", "signup" })
		public String signup() {
	return "Signup";
	}
	@GetMapping ("login")
	public String login(String email, String password){
		return "Login";
	}
	@PostMapping ("saveuser")
		public String saveuser(UserEntity userEntity){
		
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(5); //salt
		String encPassword = encoder.encode(userEntity.getPassword());
		
		userEntity.setPassword(encPassword);
		
		userEntity.setRole("USER");
		repositoryUser.save(userEntity);
		
		  serviceMail.sendWelcomeMail(userEntity.getEmail(), userEntity.getFirstname());	
			return "Login";
	}
	 @GetMapping("/forgetepassword")
	 public String forgetepassword() {
		 return "Forgetpassword";
	 }
	 @PostMapping("sendotp")
	 public String sendotp() {
		 return "sendotp";
	 }
	 @PostMapping("resetpassword")
	 public String resetpassword() {
	 	return "Resetpassword";
	 }
	 	

}
	 
	


