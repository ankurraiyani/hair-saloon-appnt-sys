package com.SalonSphereServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SalonSphereServer.entity.ShopInformation;

@Repository
public interface ShopkeeperRepository extends JpaRepository<ShopInformation,String> {
    
    @Query(value = "SELECT * FROM salonsphere.shop_information where user_id=? and isdelete=0;", nativeQuery = true)
    public List<ShopInformation> findByUserId(String userId);
	@Modifying
	@Query("UPDATE ShopInformation s SET s.isDelete = :isDelete WHERE s.shopId = :shopId")
	void updateIsDeleteById(@Param("shopId") String shopId, @Param("isDelete") boolean isDelete);
	

	
	 @Query(value="SELECT si.state, si.district, si.shop_name, u.first_name, u.last_name, u.email, u.contact_number FROM shop_informaton si \r\n"
	 		+ "	         JOIN user_information u ON si.user_id = u.user_id \r\n"
	 		+ "	         WHERE si.status = 'Pending'" , nativeQuery = true)
	    List<Object[]> findPendingShopsDetails();

}



