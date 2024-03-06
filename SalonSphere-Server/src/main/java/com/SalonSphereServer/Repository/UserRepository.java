package com.salonsphereserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salonsphereserver.entity.Users;

public interface UserRepository extends JpaRepository<Users, String>{
	
	public Users findByUserId(String userId);
}
