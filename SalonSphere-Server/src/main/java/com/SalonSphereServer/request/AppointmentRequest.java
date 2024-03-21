package com.SalonSphereServer.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AppointmentRequest {
	
	private String shopTiming;
	private int serviceDuration;
	private String shopId;
	private String serviceName;

}
