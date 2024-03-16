import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormArray, FormControl } from '@angular/forms';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';
import { AddshopserviceService } from '../../../../services/addshopservice/addshopservice.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-addshopservice',
  templateUrl: './addshopservice.component.html',
  styleUrls: ['./addshopservice.component.css']
})
export class AddshopserviceComponent {
  addServiceForm: FormGroup = new FormGroup({
    serviceList: new FormArray([this.getStudentFields()]),
  });
  
  constructor(private addShopService:AddshopserviceService,private router: Router,private formBuilder: FormBuilder){
    this.addServiceForm = this.formBuilder.group({
      serviceList: this.formBuilder.array([this.getStudentFields()])
    });
  }
  
  getStudentFields(): FormGroup {
    return new FormGroup({
      shopId: new FormControl(localStorage.getItem('shopId')),
      serviceName: new FormControl(""),
      servicePrice: new FormControl(""),
      serviceDuration: new FormControl(""),
    });
  }
  
  serviceListArray():FormArray {
    return this.addServiceForm.get("serviceList") as FormArray;
  }
  
  // addService() {
  //   this.serviceListArray().push(this.getStudentFields());
  // }

  addService() {
    this.serviceListArray().push(this.getStudentFields().value);
  }
  
  
  removeService(i: number) {
    this.serviceListArray().removeAt(i);
  }
  
  // getFormData() {
  //   this.addShopService.addshopservice(this.addServiceForm.value).subscribe((data:any)=>{
  //     console.log(data)
  //   })
  // }


  getFormData() {
    const formData = this.addServiceForm.value.serviceList;
    console.log('ADD SHOP SERVICE API CALL DATA IS',formData);
    this.addShopService.addshopservice(formData).subscribe((data: any) => {
      console.log(data);
     
    });
  }


  // getFormData() {
  //   const formData = this.addServiceForm.value.serviceList;
  //   this.addShopService.addshopservice(formData).subscribe({
  //     next: (data: any) => {
  //       console.log(data);
  //       // Handle success, e.g., show success message or redirect
  //     },
  //     error: (error: HttpErrorResponse) => {
  //       console.error(error);
  //       if (error.status === 409) {
  //         // Service already exists error handling, e.g., display a message to the user
  //         alert('Service already exists.');
  //       } else {
  //         // Other error handling, e.g., show a generic error message
  //         alert('An error occurred. Please try again.');
  //       }
  //     }
  //   });
  // }
  
  

}