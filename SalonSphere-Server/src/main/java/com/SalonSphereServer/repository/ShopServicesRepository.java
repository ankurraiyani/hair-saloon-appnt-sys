package com.SalonSphereServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.SalonSphereServer.entity.ServiceInformation;

@Repository
public interface ShopServicesRepository extends JpaRepository<ServiceInformation, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE ServiceInformation s SET s.isDelete = :isDelete WHERE s.id = :id")
    void updateIsDeleteById(@Param("isDelete") boolean isDelete, @Param("id") int id);

    // find all services based on shop_id
    @Query(value = "SELECT * FROM service_information WHERE shop_id = :shopId and isdelete = 0", nativeQuery = true)
    List<ServiceInformation> findAllServicesByShopId(@Param("shopId") String shopId);

    // Custom query using @Query to select service names by shop ID
    // @Query("SELECT s.serviceName FROM ServiceInformation s WHERE s.shopId = :shopId")
    // List<String> findServiceNamesByShopId(String shopId);

    @Query("SELECT s.serviceId, s.serviceName FROM ServiceInformation s WHERE s.shopId = :shopId")
    List<Object[]> findServiceIdAndNameByShopId(String shopId);
    
}