package com.SalonSphereServer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
}
