
package com.SalonSphereServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SalonSphereServer.entity.Users;
import com.SalonSphereServer.jwtsecurity.JwtHelper;
import com.SalonSphereServer.request.LoginRequest;
import com.SalonSphereServer.service.UserService;
import com.SalonSphereServer.response.LoginResponse;
import com.SalonSphereServer.response.RegisterResponse;

@RestController
public class CommonControllers {

	@Autowired
	private UserService userService;

	@Autowired
    private UserDetailsService userDetailsService;

	@Autowired
    private JwtHelper helper;
	
	@Autowired
	private AuthenticationManager manager;
	

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/register")
	public ResponseEntity<RegisterResponse> register(@RequestBody Users user) {

		RegisterResponse registerResponse = new RegisterResponse();
		boolean isRegister = userService.registerUser(user);

		if (isRegister == true) {
			registerResponse.setResponse("User Register Successful");
			return new ResponseEntity<>(registerResponse, HttpStatus.OK);
		} else {
			registerResponse.setResponse("User Already Register");
			return new ResponseEntity<>(registerResponse, HttpStatus.OK);
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {

		this.doAuthenticate(loginRequest.getEmail(), loginRequest.getPassword());
		LoginResponse loginResponse = userService.loginUser(loginRequest);
		System.out.println(loginRequest);
		System.out.println("aman==================="+loginResponse);
		if(loginResponse != null){

			UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
        	String token = this.helper.generateToken(userDetails);

			loginResponse.setJwtToken(token);
			return new ResponseEntity<>(loginResponse, HttpStatus.OK);

		}
		else{
			return new ResponseEntity<>(loginResponse, HttpStatus.BAD_REQUEST);
		}
	}
	
	private void doAuthenticate(String email, String password) {
		
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);
		try {
			manager.authenticate(authenticationToken);
		} catch (BadCredentialsException ex) {
			throw new BadCredentialsException("invalid user and password");
		}
	}
}
