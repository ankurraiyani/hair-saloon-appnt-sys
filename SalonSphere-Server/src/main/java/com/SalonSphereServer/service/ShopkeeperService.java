package com.SalonSphereServer.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
import com.SalonSphereServer.dto.PendingShopsDetailsDTO;
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

	// Through this method we get all pending Shop Details who are not verify by
	// admin yet
	public List<PendingShopsDetailsDTO> findPendingShopsDetails() {
		List<Object[]> results = (List<Object[]>) shopkeeperRepository.findPendingShopsDetails();
		List<PendingShopsDetailsDTO> pendingShops = new ArrayList<>();

		for (Object[] result : results) {
			PendingShopsDetailsDTO pDetailsDTO = new PendingShopsDetailsDTO();
			pDetailsDTO.setShopOwnerName((String) result[3] +" "+ (String) result[4]);
			pDetailsDTO.setShopOwnerEmail((String) result[5]);
			pDetailsDTO.setShopOwnerContactNumber((String) result[6]);
			pDetailsDTO.setShopName((String) result[2]);
			pDetailsDTO.setShopLocation((String) result[0] +" "+ (String) result[1]);

			pendingShops.add(pDetailsDTO);
		}
		return pendingShops;
	}

	private String imageDirectory= "D:\\SaloonSphere\\hair-saloon-appnt-sys\\SalonSphere-Server\\src\\main\\webapp\\images";

    public List<byte[]> getImagesByShopId(String shopId) throws IOException {
        List<byte[]> images = new ArrayList<>();
        File folder = new File(imageDirectory);

        // Filter images by shopId
        File[] files = folder.listFiles((dir, name) -> name.startsWith(shopId));

        if (files != null) {
            for (File file : files) {
                images.add(Files.readAllBytes(file.toPath()));
            }
        }

        return images;
    }
}
