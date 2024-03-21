package com.SalonSphereServer.controller;

import java.util.ArrayList;
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

import com.SalonSphereServer.repository.ShopkeeperRepository;
import com.SalonSphereServer.request.FilterRequest;
import com.SalonSphereServer.response.FilterResponse;
import com.SalonSphereServer.response.FilterResponseByCity;
import com.SalonSphereServer.service.CustomerService;

// This is Shopkeerper related  controller class  for handling shopkeeper related API
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// ============================================================================================================
	// Filter shops by given city
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/filter-by-city/{city}")
	public ResponseEntity<List<FilterResponseByCity>> filterByCity(@PathVariable String city) {

		System.out.println("====Inside the customer Controller in filterByCity===\n" + city);

		// wriet code for fiter according to city
		List<FilterResponseByCity> filterResponse = customerService.filterByCity(city);
		if (filterResponse != null)
			return ResponseEntity.ok().body(filterResponse);
		else
			return new ResponseEntity<>(filterResponse, HttpStatus.NOT_FOUND);
	}

	// ==============================================================================================================

	// Filtering based on servicename, serviceprice and distance
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/filter-shop")
	public ResponseEntity<List<FilterResponse>> filterShop(@RequestBody FilterRequest request) {

		System.out.println("====Inside the customer Controller in filtershop===\n" + request);
		List<FilterResponse> filterRespons = customerService
				.filterByCityAndServiceNameAndServicePriceAndDistance(request);

		// here we check filterResponse is empty or not
		System.out.println("This is filter respnse7777777777777777777777777777777777777777777777777777777777777\n"+filterRespons);
			return ResponseEntity.ok().body(filterRespons);

	// =================================================================================================================
}
}
