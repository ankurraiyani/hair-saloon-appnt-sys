package com.SalonSphereServer.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SalonSphereServer.common.Validation;
import com.SalonSphereServer.entity.ShopInformation;
import com.SalonSphereServer.repository.ShopkeeperRepository;

@Service
public class ShopkeeperService {

	@Autowired
	private ShopkeeperRepository shopkeeperRepository;

	// Through this method we add shopInformation to the database
	public boolean addShopInformation(ShopInformation shopInformation) {

		// Validation
		if (Validation.emailValidation(shopInformation.getShopEmail())
				&& Validation.contactNumberValidation(shopInformation.getShopContactNo())
				&& Validation.firstNameValidation(shopInformation.getShopName())
				&& Validation.addressValidation(shopInformation.getAddress())
				&& Validation.pincodeValidation(shopInformation.getPincode())) {
			System.out.println("shop keeper service");
			// Setting default values
			shopInformation.setShopId(UUID.randomUUID().toString());
			shopInformation.setDelete(false);

			// Create a java.util.Date object
			java.util.Date utilDate = new java.util.Date();

			// Convert java.util.Date to java.sql.Date
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

			shopInformation.setCreateDate(sqlDate);
			shopInformation.setModifyDate(sqlDate);

			// Set Cover image name and lincense Socument name
			System.out.println("==========================");
			System.out.println(shopInformation.getShopId() + shopInformation.getCoverImage());
			System.out.println(shopInformation.getShopId() + shopInformation.getLicenseDocument());
			shopInformation.setCoverImage(shopInformation.getShopId() + shopInformation.getCoverImage());
			shopInformation.setLicenseDocument(shopInformation.getShopId() + shopInformation.getLicenseDocument());
			ShopInformation shopInformation2 = shopkeeperRepository.save(shopInformation);

			// shopIndormation equal to null that means shop not add successfull if it is
			// not null then shop added successfully
			return shopInformation2 != null;
		}
		System.out.println("come else part");
		return false;
	}
}
