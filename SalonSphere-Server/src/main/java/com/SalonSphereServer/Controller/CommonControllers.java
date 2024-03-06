package com.SalonSphereServer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SalonSphereServer.Entity.Users;
import com.SalonSphereServer.Service.UserService;

@RestController
public class CommonControllers {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public String register(@RequestBody Users user) {

		boolean isRegister = userService.registerUser(user);
		if (isRegister == true) {
			return "Registration successful";
		} else {
			return "User all Ready Present In Databse";
		}
	}

	@PostMapping("/login")
	public String login(@RequestBody Users user) {
		return"";
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

}
