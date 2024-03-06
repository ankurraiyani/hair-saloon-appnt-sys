package com.SalonSphereServer.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.SalonSphereServer.Entity.Users;
import com.SalonSphereServer.Repository.UserRepository;
import com.SalonSphereServer.common.Validation;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	// Registring new user in database
	public boolean registerUser(Users user) {
		Users findUser = userRepository.findByEmail(user.getEmail());

		// if findUser is equal to null that means there is no such email in the
		// database so we
		if (findUser == null) {

			// Write code for validation
			if (Validation.emailValidation(user.getEmail())
					&& Validation.contactNumberValidation(user.getContactNumber())
					&& Validation.firstNameValidation(user.getFirstName())
					&& Validation.lastNameValidation(user.getLastName())
					&& Validation.passwordValidation(user.getPassword())) {
				// Setting default values
				user.setUserId(UUID.randomUUID().toString());
				user.setIsDeleted(false);
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				user.setCreatedDate(LocalDateTime.now().toString());
				user.setModifyDate(LocalDateTime.now().toString());

				// Save in the database
				findUser = userRepository.save(user);
				return true;
			}
		}
		return false;
	}
}
