package com.SalonSphereServer.response;

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
public class FilterResponse {
    private String shopName;
    private String serviceName;
    private int servicePrice;
    private int  serviceDuration;
    private String shopId;
    private String shopTiming;
    private String location;
    private String coverImage;
    private double rating;
}