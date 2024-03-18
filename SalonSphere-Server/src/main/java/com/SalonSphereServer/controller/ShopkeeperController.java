package com.SalonSphereServer.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.SalonSphereServer.dto.ShopServiceDTO;
import com.SalonSphereServer.dto.ShowShopDto;
import com.SalonSphereServer.entity.ServiceInformation;
import com.SalonSphereServer.entity.ShopInformation;
import com.SalonSphereServer.response.Response;
import com.SalonSphereServer.service.ShopServices;
import com.SalonSphereServer.service.ShopkeeperService;

// This is Shopkeerper related  controller class  for handling shopkeeper related API
@RestController
@RequestMapping("/shopkeeper")
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = false)
public class ShopkeeperController {

	@Autowired
	private ShopkeeperService shopkeeperService;

	@Autowired
	private ShopServices shopServices;

	// Through addshop API we can add new salons in the system
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/addshop", produces = MediaType.APPLICATION_JSON_VALUE)
	@Secured("shopkeeper")
	public ResponseEntity<Response> addShop(@RequestBody ShopInformation shop) {

		// Call service method to add shop
		System.out.println("======THIS IS SHOPKEEPER CONTROLLER  ADDSHOP METHOD=======" + shop.getLicenseDocument());
		boolean isAdd = shopkeeperService.addShopInformation(shop);
		if (isAdd)
			return ResponseEntity.status(HttpStatus.OK).body(new Response("Successfully added Shop"));
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new Response("Error while Updating Shop"));
	}

	// Through this api we will get shops information through id
	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("shopkeeper")
	@GetMapping("/shopid")
	public ResponseEntity<ShopInformation> getShopById(@RequestParam @NonNull String shopId) {
		Optional<ShopInformation> shopOptional = shopkeeperService.getShopDetailsByShopId(shopId);
		if (shopOptional.isPresent()) {
			return new ResponseEntity<ShopInformation>(shopOptional.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<ShopInformation>(HttpStatus.NOT_FOUND);
		}
	}

	// Through show-shop api we can show all salons of perticular user
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/show-shop/{userId}")
	public ResponseEntity<List<ShowShopDto>> showShops(@PathVariable String userId) {
		System.out.println(userId);
		return new ResponseEntity<>(shopkeeperService.getAllShops(userId), HttpStatus.OK);
	}

	// Through addshop API we can add new salons in the system
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/updateshop")
	@Secured("shopkeeper")
	public ResponseEntity<Response> updateShop(@RequestBody ShopInformation shop) {

		// Call service method to add shop
		System.out.println("======THIS IS SHOPKEEPER CONTROLLER  UPDATESHOP METHOD=======");
		boolean isUpdate = shopkeeperService.updateShopInformation(shop);
		if (isUpdate)
			return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Successfully Updated Shop"));
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new Response("Error while Updating Shop"));
	}

	// Through addshop API we can delete salons in the system
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/deleteshop")
	@Secured("shopkeeper")
	public ResponseEntity<Response> deleteShop(@RequestBody String shopId) {

		// Call service method to add shop
		System.out.println("======THIS IS SHOPKEEPER CONTROLLER  DELETESHOP METHOD=======");
		shopkeeperService.deleteShopById(shopId);
		return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Shop Deleted Successfully"));
	}

	public static String uploadDirectory = "E:\\SalonSphere Project\\hair-saloon-appnt-sys\\SalonSphere-Angular\\src\\assets\\images";

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/uploadDocument", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, String>> uploadDocument(@RequestParam("file") MultipartFile file)
			throws IOException {

		try {
			String originalFileName = file.getOriginalFilename();
			Path fileNameAndPath = Paths.get(uploadDirectory, originalFileName);
			Files.write(fileNameAndPath, file.getBytes());

			Map<String, String> response = new HashMap<>();
			response.put("status", "success");
			response.put("message", "Image uploaded successfully");

			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (Exception e) {
			Map<String, String> response = new HashMap<>();
			response.put("status", "error");
			response.put("message", "Image upload failed");

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	//this Api used for fetch the files or images
	@GetMapping("/fetchDocument/{shopId}")
	public List<byte[]> getImagesByShopId(@PathVariable String shopId) throws IOException {
		return shopkeeperService.getImagesByShopId(shopId);
	}


	//this api is for filter the shop
	@GetMapping("/search/{userId}/{keyword}")
	public ResponseEntity<List<ShowShopDto>> searchShops(@PathVariable String userId , @PathVariable String keyword) {
		System.out.println("====come inside the ShopKeeper controller search shop method =================");

		List<ShowShopDto> filterShop = shopkeeperService.searchShops(userId, keyword);
		if(filterShop!=null){
			return new ResponseEntity<>(filterShop,HttpStatus.OK);
		}
		return new  ResponseEntity<>(filterShop ,  HttpStatus.NOT_FOUND);
    }


	// API's FOR SALON KEEPER PERFORM OPERATION ON SERVICES INFORMATION HERE

	// Through addshop API we can delete salons in the system
	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("shopkeeper")
	@PostMapping("/add-service")
	public ResponseEntity<String> addService(@RequestBody @NonNull List<ServiceInformation> serviceInformation) {
		System.out.println("======THIS IS SHOPKEEPER CONTROLLER  ADDSHOP SERVICE METHOD=======" + serviceInformation);
		boolean isAdd = shopServices.addShopServices(serviceInformation);
		if (isAdd == true)
			return ResponseEntity.status(HttpStatus.CREATED).body("Service added Successfully.");
		else
			return new ResponseEntity<>("Service already exists.", HttpStatus.CONFLICT);
	}

	// Through addshop API we can update shop Service
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/updateshop-service")
	@Secured("shopkeeper")
	public ResponseEntity<String> updateShopService(@RequestBody ServiceInformation serviceInformation) {

		// Call service method to update shopService
		System.out.println(
				"======THIS IS SHOPKEEPER CONTROLLER  updatedateShopService METHOD=======" + serviceInformation);
		boolean isUpdate = shopServices.updateService(serviceInformation);
		if (isUpdate)
			return ResponseEntity.status(HttpStatus.CREATED).body("update shop Service successfull");
		else
			return ResponseEntity.status(HttpStatus.CREATED).body("shop Service update failer");
	}

	// Through addshop API we can delete salons in the system
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/deleteshop-service")
	@Secured("shopkeeper")
	public ResponseEntity<String> deleteShopService(@RequestParam int id) {

		// Call service method to add shop
		System.out.println("======THIS IS SHOPKEEPER CONTROLLER  DELETESHOP SERVICE METHOD=======");
		shopServices.deleteService(id);
		return ResponseEntity.status(HttpStatus.OK).body("Delete successfull");
	}

	@GetMapping("/showservices/{shopId}")
	public ResponseEntity<List<ShopServiceDTO>> showServices(@PathVariable String shopId) {
		System.out.println("===========================inside shop keeper controllere show services =====================");
		List<ShopServiceDTO> serviceslist = shopServices.showServices(shopId);
		if(serviceslist!=null){
			return new ResponseEntity<>(serviceslist,HttpStatus.OK);
		}
		return new  ResponseEntity<>(serviceslist ,  HttpStatus.NOT_FOUND);
    }
	// Through this api we will get shops information through shopEmail
	@SuppressWarnings("null")
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/getshopbyemail")
	public ResponseEntity<ShopInformation> getShopByEmail(@RequestBody String shopEmail) {
		System.out.println("=======GetShopinformation by email=============>" + shopEmail);
		ShopInformation sDto = shopkeeperService.getShopDetailsByShopEmail2(shopEmail);
		if (sDto != null) {
			return new ResponseEntity<>(sDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
