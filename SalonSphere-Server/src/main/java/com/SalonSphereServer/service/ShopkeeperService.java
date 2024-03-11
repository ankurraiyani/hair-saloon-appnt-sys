package com.SalonSphereServer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SalonSphereServer.dto.ShowShopDto;
import com.SalonSphereServer.entity.ShopInformation;
import com.SalonSphereServer.repository.ShopkeeperRepository;

@Service
public class ShopkeeperService {
    
    @Autowired
    private ShopkeeperRepository shopkeeperRepository;

    public List<ShowShopDto> getAllShops(String userId){
        
        List<ShopInformation> shopInfo = shopkeeperRepository.findByUserId(userId);
        List<ShowShopDto> shops = new ArrayList<ShowShopDto>();

        for(int i=0;i<shopInfo.size();i++) {
            ShopInformation shopInformation = shopInfo.get(i);
            shops.add(new ShowShopDto(shopInformation.getShopName(), shopInformation.getAddress(), shopInformation.getShopCity(), shopInformation.getShopEmail(), shopInformation.getShopContactNo(), shopInformation.isShopStatus()));
        }
        return shops;
    }
}
