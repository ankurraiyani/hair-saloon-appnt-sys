package com.SalonSphereServer.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SalonSphereServer.entity.Users;
import com.SalonSphereServer.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// Registring new user in database
	public boolean registerUser(Users user) {
		Users findUser = userRepository.findByEmail(user.getEmail());

		// if findUser is equal to null that means there is no such email in the
		// database so we
		if (findUser == null) {
			// Write code for validation

			// Setting default values
			System.out.println("come inside it");
			System.out.println(user);
			user.setUserId("1");
			user.setDeleted(false);
//			user.setCreatedDate();
//			user.setModifyDate();

			// Save in the database
			findUser = userRepository.save(user);
			return true;
		} 
		return false;
	}
}
