package com.SalonSphereServer.entity;

import java.sql.Blob;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shop_informaton")
public class ShopInformation {

    @Id
    @Column(name = "shop_id")
    private String shopId;

    @Column(name = "shop_name")
    private String shopName;

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

    @Column(name = "lincence_no")
    private String licenceNo;

    @Column(name = "license_document")
    private Blob licenseDocument;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "modify_date")
    private Date modifyDate;

    @Column(name = "isdelete")
    private boolean isDelete;

    @Column(name = "is_active")
    private boolean shopStatus;

    @Column(name = "shop_cover_image")
    private Blob coverImage;

    @Column(name = "shop_email")
    private String shopEmail;

    @Column(name = "shop_contact_no")
    private String shopContactNo;

    public void setShopStatus(boolean shopStatus) {
        this.shopStatus = shopStatus;
    }

    public void setCoverImage(Blob coverImage) {
        this.coverImage = coverImage;
    }

    public void setShopEmail(String shopEmail) {
        this.shopEmail = shopEmail;
    }

    public void setShopContactNo(String shopContactNo) {
        this.shopContactNo = shopContactNo;
    }

    public boolean isShopStatus() {
        return shopStatus;
    }

    public Blob getCoverImage() {
        return coverImage;
    }

    public String getShopEmail() {
        return shopEmail;
    }

    public String getShopContactNo() {
        return shopContactNo;
    }

    public ShopInformation() {
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    public void setLicenseDocument(Blob licenseDocument) {
        this.licenseDocument = licenseDocument;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public ShopInformation(String shopId, String shopName, String userId, int pincode, String state, String district,
            String landmark, String licenceNo, Blob licenseDocument, Date createDate, Date modifyDate, boolean isDelete,
            boolean shopStatus, Blob coverImage, String shopEmail, String shopContactNo) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.userId = userId;
        this.pincode = pincode;
        this.state = state;
        this.district = district;
        this.landmark = landmark;
        this.licenceNo = licenceNo;
        this.licenseDocument = licenseDocument;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.isDelete = isDelete;
        this.shopStatus = shopStatus;
        this.coverImage = coverImage;
        this.shopEmail = shopEmail;
        this.shopContactNo = shopContactNo;
    }

    @Override
    public String toString() {
        return "ShopInformation [shopId=" + shopId + ", shopName=" + shopName + ", userId=" + userId + ", pincode="
                + pincode + ", state=" + state + ", district=" + district + ", landmark=" + landmark + ", licenceNo="
                + licenceNo + ", licenseDocument=" + licenseDocument + ", createDate=" + createDate + ", modifyDate="
                + modifyDate + ", isDelete=" + isDelete + ", shopStatus=" + shopStatus + ", coverImage=" + coverImage
                + ", shopEmail=" + shopEmail + ", shopContactNo=" + shopContactNo + "]";
    }

    public void setDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getShopId() {
        return shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public String getUserId() {
        return userId;
    }

    public int getPincode() {
        return pincode;
    }

    public String getState() {
        return state;
    }

    public String getDistrict() {
        return district;
    }

    public String getLandmark() {
        return landmark;
    }

    public String getLicenceNo() {
        return licenceNo;
    }

    public Blob getLicenseDocument() {
        return licenseDocument;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public boolean isDelete() {
        return isDelete;
    }
}
