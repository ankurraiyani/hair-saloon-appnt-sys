package com.SalonSphereServer.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.SalonSphereServer.Entity.Users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class CommonControllers {
	
	@PostMapping("/register")
	public String register() {
		
		//write the logic for register
		return "done";
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Users user) {
		
		// write the logic for login
		
		return "done";
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	

}
