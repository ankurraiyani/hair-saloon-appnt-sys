package com.SalonSphereServer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SalonSphereServer.Entity.Users;
import com.SalonSphereServer.JWTSecurity.JwtHelper;
import com.SalonSphereServer.Repository.UserRepository;
import com.SalonSphereServer.Service.UserService;
import com.SalonSphereServer.request.LoginRequest;
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

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {

		LoginResponse loginResponse = new LoginResponse();
		boolean isLogin=userService.loginUser(loginRequest);

		if(isLogin == true){

			UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
        	String token = this.helper.generateToken(userDetails);

			LoginResponse response = loginResponse.builder()
			.jwtToken(token)
			.email(loginRequest.getEmail()).build();
		return new ResponseEntity<>(response, HttpStatus.OK);
		}
		else{
			throw new RuntimeException();
		}
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

}
