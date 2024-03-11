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
import com.SalonSphereServer.dto.ShowShopDto;
import com.SalonSphereServer.entity.ShopInformation;
import com.SalonSphereServer.repository.ShopkeeperRepository;

@Service
public class ShopkeeperService {
    
    @Autowired
    private ShopkeeperRepository shopkeeperRepository;

    //through this method we get all shop for particular shopkeeper User 
    public List<ShowShopDto> getAllShops(String userId){
        
        List<ShopInformation> shopInfo = shopkeeperRepository.findByUserId(userId);
        List<ShowShopDto> shops = new ArrayList<ShowShopDto>();

        for(int i=0;i<shopInfo.size();i++) {
            ShopInformation shopInformation = shopInfo.get(i);
            shops.add(new ShowShopDto(shopInformation.getShopName(), shopInformation.getAddress(), shopInformation.getShopCity(), shopInformation.getShopEmail(), shopInformation.getShopContactNo(), shopInformation.isShopStatus()));
        }
        return shops;
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
			shopInformation.setCoverImage(shopInformation.getShopId() + shopInformation.getCoverImage());
			shopInformation.setLicenseDocument(shopInformation.getShopId() + shopInformation.getLicenseDocument());
			ShopInformation shopInformation2 = shopkeeperRepository.save(shopInformation);

			// not null then shop added successfully
			return shopInformation2 != null;
		}
		return false;
	}

	// Through this method we find shopInformation through shopid
	public Optional<ShopInformation> getShopDetailsByShopId(@NonNull String shopId) {
		Optional<ShopInformation> shopIndormation = shopkeeperRepository.findById(shopId);
		return shopIndormation;
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
				// shopIndormation equal to null that means shop not add successfull if it is
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
}
