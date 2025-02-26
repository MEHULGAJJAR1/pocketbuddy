package com.pocketbuddy.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.pocketbuddy.entity.UserEntity;

import com.pocketbuddy.repository.UserRepository;
import com.pocketbuddy.service.MailServices;
import jakarta.servlet.http.HttpSession;

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
		 return "ForgetPassword";
	 }
	 @PostMapping("sendOtp")
	 public String sendOtp() {
		 return "ChangePassword";
	 }
	 @PostMapping("resetpassword")
	 public String resetpassword() {
	 	return "Resetpassword";
	 }
	 @PostMapping("updatepassword")
	 public String updatePassword() {
	 	return "Home";
	 }
	 @PostMapping("authenticate")
	 public String authenticate(String email, String password, Model model,HttpSession session) {
	 	System.out.println(email);
	 	System.out.println(password);
	 	
	 	Optional<UserEntity> op=repositoryUser.findByEmail(email);
	 	
	 	if (op.isPresent()) {
			
			UserEntity dbUser = op.get();

			boolean ans = encoder.matches(password, dbUser.getPassword());

			if (ans == true) {
				session.setAttribute("user", dbUser); 
				if (dbUser.getRole().equals("ADMIN")) {

					return "redirect:/admindashboard";
				} else if (dbUser.getRole().equals("USER")) {

					return "redirect:/home";
				} else {
					model.addAttribute("error", "Please contact Admin");
					return "Login";
				}

			}
		}
		model.addAttribute("error", "Invalid Credentials");
	 	return "Login";
	 }
	 @GetMapping("logout")
	 public String logout(HttpSession session) {
		 session.invalidate();
		 return "redirect:/login";
	 }
	 
	 
	 
	 

}
	 
	


