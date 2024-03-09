package com.SalonSphereServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SalonSphereServer.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {
    public Users findByEmail(String email);
}
