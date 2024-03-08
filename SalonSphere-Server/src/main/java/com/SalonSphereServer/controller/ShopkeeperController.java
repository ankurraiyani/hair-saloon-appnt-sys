package com.SalonSphereServer.controller;

import org.springframework.web.bind.annotation.RestController;

import com.SalonSphereServer.entity.Users;
import com.SalonSphereServer.response.RegisterResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// This is Shopkeerper related  controller class  for handling shopkeeper related API
@RestController
public class ShopkeeperController {

    // Through addshop API we can add new salons in the system
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addshop")
    public ResponseEntity<RegisterResponse> register(@RequestBody Users user) {

        return null;
    }
    

}
