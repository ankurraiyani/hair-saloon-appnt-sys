package com.SalonSphereServer.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.SalonSphereServer.common.Validation;
import com.SalonSphereServer.entity.ServiceInformation;
import com.SalonSphereServer.repository.ShopServicesRepository;

public class ShopServices {
    @Autowired
    private ShopServicesRepository servicesRepository;

    public boolean addShopServices(ServiceInformation serviceInformation) {

        // Validation Check
        if (Validation.firstNameValidation(serviceInformation.getServiceName())
                && (serviceInformation.getServicePrice() > 0)) {

            // Setting some Defualt value
            // Create a java.util.Date object
            java.util.Date utilDate = new java.util.Date();

            // Convert java.util.Date to java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            serviceInformation.setCreateDate(sqlDate);
            serviceInformation.setModifyDate(sqlDate);

            ServiceInformation sInformation = servicesRepository.save(serviceInformation);
            if (sInformation != null)
                return true;
        }
        return false;
    }

    public boolean updateService(ServiceInformation serviceInformation) {
        // Retrieve the service from the database
        ServiceInformation existingService = servicesRepository.findById(serviceInformation.getServiceId())
                .orElse(null);

        // Update the service fields excluding serviceId
        if (existingService != null && (Validation.firstNameValidation(serviceInformation.getServiceName())
                && (serviceInformation.getServicePrice() > 0))) {

            existingService.setServiceName(serviceInformation.getServiceName());
            existingService.setServicePrice(serviceInformation.getServicePrice());
            existingService.setShopId(serviceInformation.getShopId());
            existingService.setCreateDate(serviceInformation.getCreateDate());

            // Create a java.util.Date object
            java.util.Date utilDate = new java.util.Date();

            // Convert java.util.Date to java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            existingService.setModifyDate(sqlDate);

            // Save the updated service
            servicesRepository.save(existingService);
            return true;
        }
        return false;
    }

    public void deleteService(int id) {
        servicesRepository.updateIsDeleteById(id, true);
        return;
    }
}
