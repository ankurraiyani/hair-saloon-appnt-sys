package com.SalonSphereServer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SalonSphereServer.common.Validation;
import com.SalonSphereServer.dto.ShopOwnerDTO;
import com.SalonSphereServer.entity.ShopInformation;
import com.SalonSphereServer.entity.Users;
import com.SalonSphereServer.repository.ShopkeeperRepository;
import com.SalonSphereServer.repository.UserRepository;

@Service
public class ShopkeeperService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ShopkeeperRepository shopkeeperRepository;
	
	//call the userRepository method and fetch all the Shopkeepers data from database
	public List<ShopOwnerDTO> getAllShopKeepers(){
		
		System.out.println("come inside the services method");
		List<Users> users = userRepository.findByRole("shopkeeper");
	
		
		List<ShopOwnerDTO> shopkeepers =new ArrayList<ShopOwnerDTO>();
		
		for(int i=0;i<users.size();i++) {
			
			Users user = users.get(i);
			int numberOfShops = userRepository.findNumberOfShopsByUserId(user.getUserId());
			shopkeepers.add(new ShopOwnerDTO(user.getFirstName()+" "+user.getLastName(), user.getEmail(),user.getContactNumber(),numberOfShops));
		}
		return shopkeepers;
	}
	
	public boolean addShopInformation(ShopInformation shopInformation) {

		// Validation
		if (Validation.emailValidation(shopInformation.getShopEmail())
				&& Validation.contactNumberValidation(shopInformation.getShopContactNo())
				&& Validation.firstNameValidation(shopInformation.getShopName())
				&& Validation.addressValidation(shopInformation.getAddress())
				&& Validation.pincodeValidation(shopInformation.getPincode())) {

			System.out.println("This is shop keeper service inside add service after validation");
			// Setting default values
			shopInformation.setShopId(UUID.randomUUID().toString());
			shopInformation.setDelete(false);

			// Create a java.util.Date object
			java.util.Date utilDate = new java.util.Date();

			// Convert java.util.Date to java.sql.Date
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

			shopInformation.setCreateDate(sqlDate);
			shopInformation.setModifyDate(sqlDate);

			// This line tell shop is create and its status is pending admin approval
			// pending means not approved yet
			shopInformation.setStatus("Pending");

			// Set Cover image name and license document name
			shopInformation.setCoverImage(shopInformation.getShopId() +"_"+ shopInformation.getCoverImage());
			shopInformation.setLicenseDocument(shopInformation.getShopId() +"_"+ shopInformation.getLicenseDocument());
			ShopInformation shopInformation2 =  shopkeeperRepository.save(shopInformation);

			// not null then shop added successfully
			return shopInformation2 != null;
		}
		return false;
	}

}
