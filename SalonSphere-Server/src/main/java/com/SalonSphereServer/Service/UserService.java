package com.SalonSphereServer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SalonSphereServer.Entity.Users;
import com.SalonSphereServer.Repository.UserRepository;



@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	

	public List<Users> getUsers() {
		return userRepository.findAll();
	}
}
