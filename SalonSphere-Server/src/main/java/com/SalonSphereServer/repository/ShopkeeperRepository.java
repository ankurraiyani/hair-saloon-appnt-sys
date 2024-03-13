package com.SalonSphereServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SalonSphereServer.dto.ShowShopDto;
import com.SalonSphereServer.entity.ShopInformation;

@Repository
public interface ShopkeeperRepository extends JpaRepository<ShopInformation,String> {
    
    @Query(value = "SELECT * FROM salonsphere.shop_information where user_id=? and isdelete=0;", nativeQuery = true)
    public List<ShopInformation> findByUserId(String userId);
	@Modifying
	@Query("UPDATE ShopInformation s SET s.isDelete = :isDelete WHERE s.shopId = :shopId")
	void updateIsDeleteById(@Param("shopId") String shopId, @Param("isDelete") boolean isDelete);

	@Query(value = "SELECT si.state, si.district, si.shop_name, si.shop_email, u.first_name, u.last_name, u.email FROM shop_informaton si \r\n"
			+ "	         JOIN user_information u ON si.user_id = u.user_id \r\n"
			+ "	         WHERE si.status = 'Pending'", nativeQuery = true)
	List<Object[]> findPendingShopsDetails();
	
	@Query(name = "SELECT Count(user_id) from shop_informaton where user_id=? and isdelete = 0 and status = 'accepted'", nativeQuery = true)
	long countByUserId(String userId);

	@Query(value = "SELECT * FROM shop_information WHERE user_id = 'userId' and LOWER(shop_name) LIKE LOWER(CONCAT('%keyword%')) OR LOWER(address) LIKE LOWER(CONCAT('%keyword%')) OR LOWER(shop_city) LIKE LOWER(CONCAT('%keyword%')) OR LOWER(shop_email) LIKE LOWER(CONCAT('%keyword%')) OR LOWER(shop_contact_no) LIKE LOWER(CONCAT('%keyword%')) OR LOWER(status) LIKE LOWER(CONCAT('%keyword%'))", nativeQuery = true)
    List<ShowShopDto> search(@Param("keyword") String keyword, @Param("userId") String userId);

}



