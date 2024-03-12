package com.SalonSphereServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.SalonSphereServer.entity.ServiceInformation;

@Repository
public interface ShopServicesRepository extends JpaRepository<ServiceInformation, Integer> {

    @Transactional
    void updateIsDeleteById(int serviceId, boolean isDelete);
}
