package com.SalonSphereServer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SalonSphereServer.Entity.Users;

public interface UserRepository extends JpaRepository<Users, String> {
    public Users findByEmail(String email);
}
