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
        private String shopContactNo;
        private String shopCity;
        private String status;
        private String shopId;
        public ShowShopDto(String shopName, String shopAddress, String shopEmail, String shopContactNo, String shopCity,String status, String shopId) {
                this.shopName = shopName;
                this.shopAddress = shopAddress;
                this.shopEmail = shopEmail;
                this.shopContactNo = shopContactNo;
                this.shopCity = shopCity;
                this.status = status;
        }

        

}
