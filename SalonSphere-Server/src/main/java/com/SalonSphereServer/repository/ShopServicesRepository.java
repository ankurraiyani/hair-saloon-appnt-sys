package com.SalonSphereServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SalonSphereServer.entity.ServiceInformation;

public interface ShopServicesRepository extends JpaRepository<ServiceInformation, Integer> {

}
