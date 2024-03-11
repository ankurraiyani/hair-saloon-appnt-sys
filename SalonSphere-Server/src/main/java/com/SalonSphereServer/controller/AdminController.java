package com.SalonSphereServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SalonSphereServer.dto.CustomerDTO;
import com.SalonSphereServer.dto.ShopOwnerDTO;
import com.SalonSphereServer.repository.UserRepository;
import com.SalonSphereServer.service.CustomerService;
import com.SalonSphereServer.service.ShopkeeperService;
import com.SalonSphereServer.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ShopkeeperService shopKeeperService;

	@Autowired
	private UserService userService;

	@Autowired
    private UserRepository userRepository;

	@GetMapping("/view-customer")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<CustomerDTO>> getAllCutomers() {

		System.out.println("come inside the controller");

		return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
	}

	@GetMapping("/view-shopkeeper")
	public ResponseEntity<List<ShopOwnerDTO>> getAllShopkeepers() {

		System.out.println("come inside the contoller");
		return new ResponseEntity<>(userService.getAllShopKeepers(), HttpStatus.OK);
	}

	// this delete API for delete the user
	@SuppressWarnings("null")
	@PostMapping("/deleteuser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId){
		userRepository.deleteById(userId);
		return ResponseEntity.status(HttpStatus.OK).body("delete succesfully");
	}
}
