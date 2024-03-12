package com.SalonSphereServer.entity;

import java.util.Date;

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
@Table(name = "shop_information")
public class ShopInformation {

    @Id
    @Column(name = "shop_id")
    private String shopId;

    @Column(name = "shop_name")
    private String shopName;

    // @ManyToOne
    // @JoinColumn(name = "user_id")
    @Column(name = "user_id")
    private String userId;

    @Column(name = "pincode")
    private int pincode;

    @Column(name = "state")
    private String state;

    @Column(name = "district")
    private String district;

    @Column(name = "landmark")
    private String landmark;

    @Column(name = "address")
    private String address;

    @Column(name = "licence_no")
    private String licenceNo;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "modify_date")
    private Date modifyDate;

    @Column(name = "isdelete")
    private boolean isDelete;

    @Column(name = "is_active")
    private boolean shopStatus;

    @Column(name = "license_document")
    private String licenseDocument;

    @Column(name = "shop_cover_image")
    private String coverImage;

    @Column(name = "shop_email",unique = true)
    private String shopEmail;

    @Column(name = "shop_contact_no",unique = true)
    private String shopContactNo;

    @Column(name = "shop_city")
    private String shopCity;

    // through this cloum shop owner check yourself shop is accepted by admin or
    // not. chencges according to Aman
    @Column(name = "status")
    private String status;
}
