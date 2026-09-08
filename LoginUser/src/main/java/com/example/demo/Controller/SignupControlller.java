package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserServiceImpl;

@RestController
public class SignupControlller {
	@Autowired
	UserServiceImpl serviceImpl;
	
    @PostMapping("signup")
	public String signup(Model model){
		model.addAttribute("user", model);
		return null;
	}
    
     @PostMapping("signupForm")
     ResponseEntity SignUpForm(Model model) {
    	 
    	 model.addAttribute("user", model);
		return new ResponseEntity<>("Welcome", HttpStatus.CREATED);
    	 
     }
    
}
