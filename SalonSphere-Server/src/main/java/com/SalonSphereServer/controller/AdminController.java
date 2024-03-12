package com.SalonSphereServer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SalonSphereServer.dto.CustomerDTO;
import com.SalonSphereServer.dto.PendingShopsDetailsDTO;
import com.SalonSphereServer.dto.ShopOwnerDTO;
import com.SalonSphereServer.entity.ShopInformation;
import com.SalonSphereServer.repository.UserRepository;
import com.SalonSphereServer.service.CustomerService;
import com.SalonSphereServer.service.ShopkeeperService;
import com.SalonSphereServer.service.UserService;

@RestController
// @RequestMapping("/admin")
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
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<ShopOwnerDTO>> getAllShopkeepers() {

		System.out.println("come inside the contoller");
		return new ResponseEntity<>(userService.getAllShopKeepers(), HttpStatus.OK);
	}

	// this delete API for delete the user
	@SuppressWarnings("null")
	@PostMapping("/deleteuser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId) {
		userRepository.deleteById(userId);
		return ResponseEntity.status(HttpStatus.OK).body("delete succesfully");
	}

	// Through this api , we can fetch all request of shop request Details
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/shop-requests")
	public ResponseEntity<List<PendingShopsDetailsDTO>> getShopRequestDetails() {
		List<PendingShopsDetailsDTO> pendingShopsDetailsDTOs = shopKeeperService.findPendingShopsDetails();
		System.out.println("iN SIDE ADMIN pENDINGSHOPDETAILS====");
		if (pendingShopsDetailsDTOs != null)
			return new ResponseEntity<>(pendingShopsDetailsDTOs, HttpStatus.OK);
		return new ResponseEntity<>(pendingShopsDetailsDTOs, HttpStatus.NOT_FOUND);
	}

	// Through this api we will get shops information through shopEmail
	@CrossOrigin(origins = "http://localhost:4200")
	// @Secured("admin")
	@PostMapping("/view-requests/review-shop")
	public ResponseEntity<ShopInformation> getShopById(@RequestParam @NonNull String shopEmail) {
		System.out.println("getShopinformation by email=============>"+shopEmail);
		ShopInformation shopOptional = shopKeeperService.getShopDetailsByShopEmail(shopEmail);
		if (shopOptional!=null) {
			return new ResponseEntity<>(shopOptional, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// This method is used to accept or reject the Shop Request by admin
	@CrossOrigin(origins = "http://localhost:4200")
	// @Secured("admin")
	@GetMapping("/view-requests/approve-request")
	public ResponseEntity<?> approveRequest() {
		// Optional<ShopInformation> shopOptional
		// =shopKeeperService.getShopDetailsByShopId(shopEmail);
		// if (shopOptional.isPresent()) {
		// return new ResponseEntity<>(shopOptional.get(), HttpStatus.OK);
		// } else {
		// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		// }
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	// @Secured("admin")
	@GetMapping("/view-requests/reject-request")
	public ResponseEntity<?> rejectRequest() {
		// Optional<ShopInformation> shopOptional
		// =shopKeeperService.getShopDetailsByShopId(shopEmail);
		// if (shopOptional.isPresent()) {
		// return new ResponseEntity<>(shopOptional.get(), HttpStatus.OK);
		// } else {
		// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		// }

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
