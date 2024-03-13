package com.SalonSphereServer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ShopReviewDTO {

	
	  private String  shopName;
	  private String shopContactNo;
	  private String state;
	  private String district;
	  private String landmark;
	  private String licenseDocument;
	 
	
}
