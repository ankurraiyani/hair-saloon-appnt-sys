package com.SalonSphereServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SalonSphereServer.entity.ShopInformation;

public interface ShopkeeperRepository extends JpaRepository<ShopInformation, String> {
    
}
