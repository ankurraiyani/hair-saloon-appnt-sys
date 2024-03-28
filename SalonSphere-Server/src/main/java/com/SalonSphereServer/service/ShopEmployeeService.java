package com.SalonSphereServer.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SalonSphereServer.common.Validation;
import com.SalonSphereServer.entity.EmployeeService;
import com.SalonSphereServer.entity.ShopEmployees;
import com.SalonSphereServer.repository.EmployeeServiceRepository;
import com.SalonSphereServer.repository.ShopEmployeeRepository;
import com.SalonSphereServer.repository.ShopkeeperRepository;

@Service
public class ShopEmployeeService {

    @Autowired
    private ShopEmployeeRepository shopEmployeeRepository;
    @Autowired
    private ShopkeeperRepository shopkeeperRepository;
    @Autowired
    private EmployeeServiceRepository employeeServiceRepository;

    // Through this method we add employee in salon
    @SuppressWarnings("null")
    public boolean addEmp(ShopEmployees emp) {
        boolean exists = shopkeeperRepository.existsById(emp.getShopId());
        // Validation Employe
        if (exists && Validation.firstNameValidation(emp.getEmployeeName())) {

            String empId = UUID.randomUUID().toString();
            emp.setEmployeeId(empId);
            List<EmployeeService> empService = emp.getServices();
            ShopEmployees isAdd = shopEmployeeRepository.save(emp);
            empService = employeeServiceRepository.saveAll(empService);
            if (isAdd != null && empService != null) {
                return true;
            } else {
                // Rollback if either employee or services saving fails
                shopEmployeeRepository.delete(emp); // Rollback employee addition
                empService.forEach(service -> employeeServiceRepository.delete(service)); // Rollback service addition
            }
        }
        return false;
    }
    
    // Through this method we find all employee in particular shop by shopId
    public  List<ShopEmployees> showAllEmpByShopId(String shopId) {        
        List<ShopEmployees> listOfEmps=shopEmployeeRepository.findShopEmployeesByShopId(shopId);
        return listOfEmps;
    }

    // This method give  us the details of a specific employee by employeeId
    @SuppressWarnings("null")
    public ShopEmployees showEmpByEmpId(String empId){
       Optional<ShopEmployees> optional= shopEmployeeRepository.findById(empId);
       ShopEmployees emps=optional.get() ;
       return  emps;
    }
}
