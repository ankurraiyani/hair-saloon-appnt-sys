
package com.SalonSphereServer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD:SalonSphere-Server/src/main/java/com/SalonSphereServer/Controller/CommonControllers.java
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
=======
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
>>>>>>> aman:SalonSphere-Server/src/main/java/com/SalonSphereServer/controller/CommonControllers.java
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SalonSphereServer.Entity.Users;
import com.SalonSphereServer.Service.UserService;
import com.SalonSphereServer.response.RegisterResponse;

@RestController
public class CommonControllers {

	@Autowired
	private UserService userService;

<<<<<<< HEAD:SalonSphere-Server/src/main/java/com/SalonSphereServer/Controller/CommonControllers.java
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/register")
	public ResponseEntity<RegisterResponse> register(@RequestBody Users user) {

		RegisterResponse registerResponse = new RegisterResponse();
=======
	 @CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/register")
	public String register(@RequestBody Users user) {
		 System.out.println("hello aman");
>>>>>>> aman:SalonSphere-Server/src/main/java/com/SalonSphereServer/controller/CommonControllers.java
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
	public String login(@RequestBody Users user) {
<<<<<<< HEAD:SalonSphere-Server/src/main/java/com/SalonSphereServer/Controller/CommonControllers.java
		return "";
=======
		return"done";
>>>>>>> aman:SalonSphere-Server/src/main/java/com/SalonSphereServer/controller/CommonControllers.java
	}
}
