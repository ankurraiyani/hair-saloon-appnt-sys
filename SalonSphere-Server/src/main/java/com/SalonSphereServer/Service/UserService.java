package com.SalonSphereServer.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SalonSphereServer.Entity.Users;
import com.SalonSphereServer.Repository.UserRepository;

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
			user.setuserId(UUID.randomUUID().toString());
			user.setIsdeleted(false);
			user.setcreatedDate(LocalDateTime.now().toString());
			user.setmodifyDate(LocalDateTime.now().toString());

			// Save in the database
			findUser = userRepository.save(user);
			return true;
		} else {
			return false;
		}
	}
}
