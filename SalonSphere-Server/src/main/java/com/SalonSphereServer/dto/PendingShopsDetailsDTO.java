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
public class PendingShopsDetailsDTO {

	private String shopOwnerName;
	private String shopOwnerEmail;
	private String shopEmail;
	private String shopName;
	private String shopLocation;

}
