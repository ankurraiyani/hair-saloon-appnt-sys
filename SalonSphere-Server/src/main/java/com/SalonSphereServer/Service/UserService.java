package com.salonsphereserver.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salonsphereserver.entity.Users;
import com.salonsphereserver.repository.UserRepository;

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
			user.setUser_Id(UUID.randomUUID().toString());
			user.setIsdeleted(false);
			user.setCreated_date(LocalDateTime.now().toString());
			user.setModify_date(LocalDateTime.now().toString());

			// Save in the database
			findUser = userRepository.save(user);
			return true;
		} else {
			return false;
		}
	}
}
