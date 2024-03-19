package com.SalonSphereServer.dto;

import java.util.Date;

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
public class ShopServiceDTO {

    private int serviceId;
    private String serviceName;
    private Double servicePrice;
    private String serviceDuration;
    private Date createDate;

    
}
