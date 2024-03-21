import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { AddshopService } from '../services/addshopservice/addshop.service';
import { Cookie } from 'ng2-cookies';
import { GetshopService } from '../services/getshop/getshop.service';
import { FetchshopInfoService } from '../services/fetchshopInfo/fetchshop-info.service';
import { PincodeService } from '../services/common/pincode.service';
import { ShopregisterService } from '../services/shopregister/shopregister.service';
import { ImageService } from '../services/common/image.service';
import { UpdateShopService } from '../services/updateShop/update-shop.service';
import { DeleteShopService } from '../services/deleteShop/delete-shop.service';
import { GetServiceInfoService } from '../services/fetchShopServices/get-service-info.service';
import {MatTableModule} from '@angular/material/table';
import { RegisterService } from '../services/register/register.service';


interface shopData {
  shopName: string;
  shopEmail: string;
  createdDate: string;
}

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrl: './about.component.css'
})
export class AboutComponent {

  selectedServices: string[] = [];
  services: string[] = ['Service 1', 'Service 2', 'Service 3']; 
  
  EmpRegister = new FormGroup({
    Name: new FormControl(''),
    email: new FormControl(''),
    contactNumber: new FormControl(''),
    salary: new FormControl(''),
    gender: new FormControl(''),
    selectedServices:new FormControl(''),
    address: new FormControl('')
  });

 

  constructor(private formBuilder: FormBuilder, private registerService:RegisterService, private router:Router) { }

  ngOnInit(): void {
    this.EmpRegister = this.formBuilder.group({
      Name: [''],
      email: [''],
      contactNumber: [''],
      salary:[''],
      gender: ['male'], // Set the default value for gender
      selectedServices:[''],
      address:['']
    });
  }

  onServiceSelected(event: Event) {
    const target = event.target as HTMLSelectElement;
    const value = target.value;
    if (value && !this.selectedServices.includes(value)) {
      this.selectedServices.push(value);
    }
  }

  removeService(service: string) {
    const index = this.selectedServices.indexOf(service);
    if (index !== -1) {
      this.selectedServices.splice(index, 1);
    }
  }

  //Validate the data of the form and send the data to the service
  doSubmit() {
    // alert('values comes');
    console.log(this.EmpRegister.value);

    //check first name and last name
    let message = this.validateName(
      this.EmpRegister.value.Name
    );

    if (message != '') {
      Swal.fire({
        title: 'Error!',
        text: message,
        icon: 'error',
      });
      return;
    }

    //Check email
    message = this.validateEmail(this.EmpRegister.value.email);

    if (message != '') {
      Swal.fire({
        title: 'Error!',
        text: message,
        icon: 'error',
      });
      return;
    }

    //check contact number
    message = this.validateContactNumber(this.EmpRegister.value.contactNumber);

    if (message != '') {
      Swal.fire({
        title: 'Error!',
        text: message,
        icon: 'error',
      });
      return;
    }


    // //if everything is okey then call the service method
    // this.registerService.registerUser(this.EmpRegister.value).subscribe((response) => {
    //   console.log('Response from server : ', response);
    //   Swal.fire({
    //     title: "Register Successfully!!",
    //     text: "You can login now",
    //     icon: "success"
    //   });

    //   //and Navigate to the login page
    //   this.router.navigate(["/login"]);
    // },
    // if any  error occured while registering user 
    // error=> {
    //   Swal.fire({
    //     title: "Server Error",
    //     text: "There is something wrong please try again",
    //     icon: "success"
    //   });
    // })
  }

  //Validate the name fields
  validateName(Name: any): string {
    let message = '';

    // Check if either of the fields is empty
    if (!Name) {
      message = 'Please enter the first name and last name';
      return message;
    }

    // Check if the first and last names contain at least two characters
    if (Name.length < 2) {
      message =
        'Name must contain at least two characters each.';
      return message;
    }

    // Check if the first and last names contain only alphabets
    const nameRegex = /^[A-Za-z]+$/;

    if (!nameRegex.test(Name)) {
      message = 'Name must contain only alphabets.';
      return message;
    }

    // If all validations pass
    return message; // Return an empty string indicating success
  }

  //validate the email
  validateEmail(email: any): string {
    let message = '';

    if (!email) {
      message = 'Please Enter the email';
      return message;
    }

    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z]+\.[a-z]{2,3}$/;
    if (!emailRegex.test(email)) {
      message = 'Please enter a valid email address.';
      return message;
    }

    // If all validations pass
    return message; // Return an empty string indicating success
  }

  validateContactNumber(contactNumber: any): string {
    let message = '';

    //check if the contactNumber is empty or not
    if (!contactNumber) {
      message = 'Please Enter the Contact Number';
      return message;
    }

    //check if the contact number contain only 10 digit
    // if (contactNumber.length != 10) {
    //   message = 'Please Enter the 10 digit Contact number';
    //   return message;
    // }

    // Check if the contact number is valid
    const contactNumberRegex = /^\d{10}$/; // assuming a 10-digit number
    if (!contactNumberRegex.test(contactNumber)) {
      message = 'Please enter a valid contact number.';
      return message;
    }

    // If all validations pass
    return message; // Return an empty string indicating success
  }

  //Validate the name fields
  validateAddress(address: any): string {
    let message = '';
    address = address.trim();

    // Check if either of the fields is empty
    if (!address) {
      message = 'Please enter the address';
      return message;
    }

    // Check if the first and last names contain at least two characters
    if (address.length < 10) {
      message =
        'Address must contain at least ten characters each.';
      return message;
    }

    const addressRegex = /^(?=.*[a-zA-Z])[\w\s.,-]*$/;
    if (!addressRegex.test(address)) {
      message = 'Please enter a valid address of employee.';
      return message;
    }


    // If all validations pass
    return message; // Return an empty string indicating success
  }

}