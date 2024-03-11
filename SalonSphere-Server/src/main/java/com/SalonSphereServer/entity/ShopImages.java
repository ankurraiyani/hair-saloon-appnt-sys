package com.SalonSphereServer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shop_images")
public class ShopImages {

    @Id
    @Column(name = "image_id")
    private String imageId;

    @Column(name = "shop_id")
    private String shopId;

    @Column(name = "image")
    private String image;

    public ShopImages() {
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageId() {
        return imageId;
    }

    public String getShopId() {
        return shopId;
    }

    @Override
    public String toString() {
        return "ShopImages [imageId=" + imageId + ", shopId=" + shopId + ", image=" + image + "]";
    }

    public String getImage() {
        return image;
    }

    public ShopImages(String imageId, String shopId, String image) {
        this.imageId = imageId;
        this.shopId = shopId;
        this.image = image;
    }

}
