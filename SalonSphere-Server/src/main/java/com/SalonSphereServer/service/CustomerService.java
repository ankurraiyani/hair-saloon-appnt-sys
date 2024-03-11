package com.SalonSphereServer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SalonSphereServer.dto.CustomerDTO;
import com.SalonSphereServer.entity.Users;
import com.SalonSphereServer.repository.UserRepository;

@Service
public class CustomerService {
	
	@Autowired
	private UserRepository userRepository;
	
	//call the userRepository method and fetch all the customer data from database
	public List<CustomerDTO> getAllCustomers(){
		
		System.out.println("come inside the services method");
		List<Users> users = userRepository.findByRole("customer");
		
		List<CustomerDTO> cutomers =new ArrayList<CustomerDTO>();
		
		for(int i=0;i<users.size();i++) {
			
			Users user = users.get(i);
			cutomers.add(new CustomerDTO(user.getFirstName()+" "+user.getLastName(), user.getEmail(),user.getContactNumber()));
		}
		return cutomers;
	}
	

}
