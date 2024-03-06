package com.salonsphereserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salonsphereserver.entity.Users;
import com.salonsphereserver.repository.UserRepository;



@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	

	public List<Users> getUsers() {
		return userRepository.findAll();
	}
}
