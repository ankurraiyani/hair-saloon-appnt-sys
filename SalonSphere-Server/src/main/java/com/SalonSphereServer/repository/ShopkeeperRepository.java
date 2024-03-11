package com.SalonSphereServer.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SalonSphereServer.entity.ShopInformation;

@Repository
public interface ShopkeeperRepository extends JpaRepository<ShopInformation,String> {
    
    @Query(value = "SELECT * FROM salonsphere.shop_informaton where user_id=? and isdelete=0;", nativeQuery = true)
    public List<ShopInformation> findByUserId(String userId);

}
