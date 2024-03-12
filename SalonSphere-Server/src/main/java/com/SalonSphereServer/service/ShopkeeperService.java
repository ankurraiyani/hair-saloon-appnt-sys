package com.SalonSphereServer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SalonSphereServer.common.Validation;
import com.SalonSphereServer.dto.ShopOwnerDTO;
import com.SalonSphereServer.entity.ShopInformation;
import com.SalonSphereServer.entity.Users;
import com.SalonSphereServer.repository.ShopkeeperRepository;
import com.SalonSphereServer.repository.UserRepository;
import com.SalonSphereServer.dto.PendingShopsDetailsDTO;


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
			long numberOfShops = shopkeeperRepository.countByUserId(user.getUserId());
			shopkeepers.add(new ShopOwnerDTO(user.getFirstName()+" "+user.getLastName(), user.getEmail(),user.getContactNumber(),numberOfShops));
		}
		return shopkeepers;
	}


	// Through this method we add shopInformation to the database
	public boolean addShopInformation(ShopInformation shopInformation) {

		// Validationlida
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

			// Set Cover image name and lincense document name
			shopInformation.setCoverImage(shopInformation.getShopId() +"_"+ shopInformation.getCoverImage());
			shopInformation.setLicenseDocument(shopInformation.getShopId() +"_"+ shopInformation.getLicenseDocument());
			ShopInformation shopInformation2 = shopkeeperRepository.save(shopInformation);

			// not null then shop added successfully
			return shopInformation2 != null;
		}
		return false;
	}
	
	// Through this method we find shopInformation through shopid
	public Optional<ShopInformation> getShopDetailsByShopId(@NonNull String shopId) {
		Optional<ShopInformation> shopInformation = shopkeeperRepository.findById(shopId);
		return shopInformation;
	}

	// Through this method we upadte shopInformation to the database
	public boolean updateShopInformation(ShopInformation shopInformation) {

		// Validation
		if (Validation.emailValidation(shopInformation.getShopEmail())
				&& Validation.contactNumberValidation(shopInformation.getShopContactNo())
				&& Validation.firstNameValidation(shopInformation.getShopName())
				&& Validation.addressValidation(shopInformation.getAddress())
				&& Validation.pincodeValidation(shopInformation.getPincode())) {

			System.out.println("This is shop keeper service inside update service after validation");

			// Create a java.util.Date object
			java.util.Date utilDate = new java.util.Date();

			// Convert java.util.Date to java.sql.Date
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			shopInformation.setModifyDate(sqlDate);

			// Cheking cover image and licence document name is null or not if null then set
			// default name
			if (shopInformation.getCoverImage() == null && shopInformation.getLicenseDocument() == null) {
				shopInformation.setCoverImage(shopInformation.getShopId() + shopInformation.getCoverImage());
				shopInformation.setLicenseDocument(shopInformation.getShopId() + shopInformation.getLicenseDocument());
			} else if (shopInformation.getCoverImage() == null) {
				shopInformation.setCoverImage(shopInformation.getShopId() + shopInformation.getCoverImage());
			} else if (shopInformation.getLicenseDocument() == null) {
				shopInformation.setLicenseDocument(shopInformation.getShopId() + shopInformation.getLicenseDocument());
			} else {
				
				
				ShopInformation shopInformation2 = shopkeeperRepository.save(shopInformation);
				// shopInformation equal to null that means shop not add successfull if it is
				// not null then shop added successfully
				return shopInformation2 != null;
			}
		}
		return false;
	}

	// Through this method we delete Shop from the database and mark isDeleted=true
	// in the table but we not delete data physically,we just make flag true
	@Transactional
	public void deleteShopById(String shopId) {
		shopkeeperRepository.updateIsDeleteById(shopId, true);
		return;
	}

	// Through this method we get all pending Shop Details which status is pending
	public List<PendingShopsDetailsDTO> findPendingShopsDetails() {
		List<Object[]> results = (List<Object[]>) shopkeeperRepository.findPendingShopsDetails();
		List<PendingShopsDetailsDTO> pendingShops = new ArrayList<>();

		for (Object[] result : results) {
			PendingShopsDetailsDTO pendingShopDetailDTO = new PendingShopsDetailsDTO();
			pendingShopDetailDTO.setShopOwnerName((String) result[4] +" "+ (String) result[5]);
			pendingShopDetailDTO.setShopOwnerEmail((String) result[6]);
			pendingShopDetailDTO.setShopEmail((String) result[3]);
			pendingShopDetailDTO.setShopName((String) result[2]);
			pendingShopDetailDTO.setShopLocation((String) result[0] +" "+ (String) result[1]);

			pendingShops.add(pendingShopDetailDTO);
		}
		return pendingShops;
	}
}

