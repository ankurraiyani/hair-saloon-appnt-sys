package com.SalonSphereServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SalonSphereServer.entity.ShopInformation;
import com.SalonSphereServer.service.ShopkeeperService;

// This is Shopkeerper related  controller class  for handling shopkeeper related API
@RestController
@RequestMapping("/shopkeeper")
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = false)
public class ShopkeeperController {

	@Autowired
	private ShopkeeperService shopkeeperService;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addshop")
	@Secured("shopkeeper")
	public ResponseEntity<String> addShop(@RequestBody ShopInformation shop) {

		// Call service method to add shop
		System.out.println("cm===============================");
		boolean isAdd = shopkeeperService.addShopInformation(shop);
		if (isAdd)
			return ResponseEntity.status(HttpStatus.CREATED).body("success");
		else
			return ResponseEntity.status(HttpStatus.CREATED).body("failer");
	}
}
