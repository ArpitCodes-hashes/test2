package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.RepoSitory.UserRepository;
@Service
public class UserServiceImpl implements UserDetailsService{
   
	@Autowired
	UserRepository repository;
	
	final PasswordEncoder passwordEncoder;

	UserServiceImpl(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	 User user= repository.findbyUsername(username);
	UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
         .username(user.getName())
     .password(user.getPassword())
     .roles(user.getRole().split(","))
     .build();
		
     
		return null;
	}

     public void registerUser(User user) {
    	 if (user == null) {
			throw new RuntimeException("invalid user");
		}
    	 repository.save(user);
    	 
     }


	

}
