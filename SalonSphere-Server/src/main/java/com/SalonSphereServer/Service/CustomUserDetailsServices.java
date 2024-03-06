package com.SalonSphereServer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SalonSphereServer.Entity.Users;
import com.SalonSphereServer.Repository.UserRepository;

@Service
public class CustomUserDetailsServices  implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Users user=userRepository.findByEmail(email);
		return user;		
	}
}
