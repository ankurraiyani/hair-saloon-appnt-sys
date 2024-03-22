package com.SalonSphereServer.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SlotBookingRequest {

	private String slotTime;
	private String empId;
	private String serviceName;
	private int serviceTime;
	private String date;
	
	
	
}
