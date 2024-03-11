package com.SalonSphereServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SalonSphereServer.dto.ShowShopDto;
import com.SalonSphereServer.entity.Users;
import com.SalonSphereServer.response.RegisterResponse;
import com.SalonSphereServer.service.ShopkeeperService;


// This is Shopkeerper related  controller class  for handling shopkeeper related API
@RestController
@RequestMapping("/shopkeeper")
public class ShopkeeperController {

    @Autowired
    private ShopkeeperService shopkeeperService;

    // Through addshop API we can add new salons in the system
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addshop")
    public ResponseEntity<RegisterResponse> register(@RequestBody Users user) {

        return null;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/show-shop/{id}")
    public ResponseEntity<List<ShowShopDto>> showShops(@PathVariable String userId) {
        return new ResponseEntity<>(shopkeeperService.getAllShops(userId),HttpStatus.OK);
    }
    
    

}
