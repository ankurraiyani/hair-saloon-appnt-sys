package com.SalonSphereServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SalonSphereServer.entity.ShopEmployees;

@Repository
public interface ShopEmployeeRepository  extends JpaRepository<ShopEmployees, String>{
	
	@Query(value = "select e.employee_id, e.employee_name from shop_employees e where e.shop_id = :shopId", nativeQuery = true)
	List<Object[]> findShopEmplooyesByShopId(@Param("shopId") String shopId);
}
