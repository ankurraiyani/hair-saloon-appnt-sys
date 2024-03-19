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

		// here we are checking whether all fields of FilterRequest are empty or not
		if (request.getServiceName() != null && request.getDistance() == null && request.getPrice() == null) {
			// here we calling a methodn from customerservoce which is
			// filterByServiceNameAndCity
			System.out.println("++++INSIDE THE CITY AND SERVICENAME FILLER IF CONDITION++++\n");
			List<FilterResponse> filterRespons = customerService.filterByServiceNameAndCity(request.getServiceName(),
					request.getCity());

			// here we check filterResponse is empty or not
			if (!filterRespons.isEmpty())
				return ResponseEntity.ok().body(filterRespons);
			else
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		} else if (request.getServiceName() != null && request.getPrice() != null && request.getDistance() == null) {
			// write code for filtering by category for service name and city

			System.out.println("++++INSIDE THE CITY,SERVICENAME AND SERVICEPRICERANGE FILLER ELSE IF CONDITION++++\n");
			List<FilterResponse> filterRespons = customerService.filterByCityAndServiceNameAndServicePrice(
					request.getCity(), request.getServiceName(), request.getPrice());

			// here we check filterResponse is empty or not
			if (!filterRespons.isEmpty())
				return ResponseEntity.ok().body(filterRespons);
			else
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {

			System.out.println("+++INSIDE THE CITY,SERVICENAME,SERVICEPRICERANGE AND DISTANCERANGE FILLER ELSE IF CONDITION++++\n");

			// write code for filtering by category for service name , city , price range
			// and distance
			List<FilterResponse> filterRespons = customerService.filterByCityAndServiceNameAndServicePriceAndDistance(request.getCity(), request.getServiceName(), request.getPrice(), request.getDistance());

			// here we check filterResponse is empty or not
			if (!filterRespons.isEmpty())
				return ResponseEntity.ok().body(filterRespons);
			else
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	// =================================================================================================================
}

//if (request.getServiceName() != null && request.getCity() != null && request.getPrice() != null
//&& request.getDistance() != null)
