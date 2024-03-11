package com.SalonSphereServer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SalonSphereServer.dto.ShopOwnerDTO;
import com.SalonSphereServer.entity.Users;
import com.SalonSphereServer.repository.UserRepository;

@Service
public class ShopkeeperService {
	
	@Autowired
	private UserRepository userRepository;
	
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

}
