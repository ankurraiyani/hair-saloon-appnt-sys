package com.SalonSphereServer.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ShowShopDto {

        private String shopName;
        private String shopAddress;
        private String shopEmail;
        private String contactNumber;
        private String city;
        private boolean status;
        public ShowShopDto(String shopName, String shopAddress, String shopEmail, String contactNumber, String city,
                        boolean status) {
                this.shopName = shopName;
                this.shopAddress = shopAddress;
                this.shopEmail = shopEmail;
                this.contactNumber = contactNumber;
                this.city = city;
                this.status = status;
        }

        

}
