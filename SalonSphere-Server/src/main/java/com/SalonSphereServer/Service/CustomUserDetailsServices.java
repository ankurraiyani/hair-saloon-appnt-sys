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
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		Users user = userRepository.findByUserId(userId);
//		.orElseThrow(() -> new RuntimeException("User not found"));
		if(user==null) {
			throw new RuntimeException("user not found");
		}
		return (UserDetails) user;
	}

}
