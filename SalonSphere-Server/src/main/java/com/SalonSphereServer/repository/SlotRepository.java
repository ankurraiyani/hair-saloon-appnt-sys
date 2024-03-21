package com.SalonSphereServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SalonSphereServer.entity.Slots;

@Repository
public interface SlotRepository extends JpaRepository<Slots, String> {
	
	@Query(value = "select s.slot_time from slots s where employee_id = :employeeId", nativeQuery = true)
	List<String> findAllSlotTimeByEmployeeId(@Param("employeeId") String employeeId);
	

}
