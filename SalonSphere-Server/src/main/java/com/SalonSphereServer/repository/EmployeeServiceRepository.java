package com.SalonSphereServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SalonSphereServer.entity.EmployeeService;

@Repository
public interface EmployeeServiceRepository extends JpaRepository<EmployeeService, String>  {

}
