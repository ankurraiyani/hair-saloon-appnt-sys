package com.SalonSphereServer.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "service_information")
public class ServiceInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "service_id")
    private int serviceId;

    @Column(name = "service_name",nullable = false)
    private String serviceName;

    @Column(name = "service_price", nullable=false)
    private double servicePrice;
    
    @Column(name = "service_duration", nullable=false)
    private int serviceDuration;

    @Column(name = "shop_id", nullable=false)
    private String shopId;

    @Column(name = "create_date", nullable=false, updatable=false)
    private Date createDate;

    @Column(name = "modify_date", nullable=true)
    private Date modifyDate;

    @Column(name = "isdelete", nullable=false)
    private boolean isDelete;

}
