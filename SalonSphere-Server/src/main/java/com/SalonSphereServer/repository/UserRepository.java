package com.SalonSphereServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SalonSphereServer.entity.Users;



public interface UserRepository extends JpaRepository<Users, String> {
    public Users findByEmail(String email);
}
