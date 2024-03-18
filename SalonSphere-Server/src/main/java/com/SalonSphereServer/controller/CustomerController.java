package com.SalonSphereServer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SalonSphereServer.request.FilterRequest;
import com.SalonSphereServer.response.FilterResponse;

// This is Shopkeerper related  controller class  for handling shopkeeper related API
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @PostMapping("/filter-shop")
    public ResponseEntity<FilterResponse> filterShop(@RequestBody FilterRequest request) {

        System.out.println("====Inside the customer Controller in filtershop===\n" + request);

        if (request.getServiceName() == null && request.getCity() == null && request.getDistance() == null
                && request.getPrice() == null) {

            // wriet code for fiter according to city
                    





        } else if (request.getServiceName() != null && request.getCity() == null && request.getDistance() == null
                && request.getPrice() == null) {

            // Setting Defult value

            // write code for filtering by category for service name and city
        } else if (request.getServiceName() != null && request.getCity() != null && request.getPrice() != null
                && request.getDistance() == null) {

            // Setting Defult value

            // write code for filtering by category for service name , city and price range

        } else if (request.getServiceName() != null && request.getCity() != null && request.getPrice() != null
                && request.getDistance() != null) {

            // Setting Defult value

            // write code for filtering by category for service name , city , price range
            // and distance
        }

        return null;
    }

}
