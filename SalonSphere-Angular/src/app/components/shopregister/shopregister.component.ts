import { Component } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { ShopregisterService } from '../services/shopregister/shopregister.service';
import { PincodeService } from '../services/common/pincode.service';
import { ImageService } from '../services/common/image.service';
import { error } from 'console';

@Component({
  selector: 'app-shopregister',
  templateUrl: './shopregister.component.html',
  styleUrl: './shopregister.component.css',
})
export class ShopregisterComponent {
  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private shopregisterService: ShopregisterService,
    private postalCodeService: PincodeService,
    private fb: FormBuilder,
    private upload: ImageService
  ) {}

  file: any;

  register = new FormGroup({
    shopName: new FormControl('',Validators.required),
    licence: new FormControl('',Validators.required),
    licenceDocument: new FormControl('',Validators.required),
    coverDocument: new FormControl('',Validators.required),
    email: new FormControl('',Validators.required),
    contactNumber: new FormControl('',Validators.required),
    address: new FormControl('',Validators.required),
    landmark: new FormControl('',Validators.required),
    pincode: new FormControl('',Validators.required),
    city: new FormControl('',Validators.required),
    district: new FormControl('',Validators.required),
    state: new FormControl('',Validators.required),
    country: new FormControl('',Validators.required),
  });

  ngOnInit(): void {
    this.register = this.formBuilder.group({
      shopName: [''],
      licence: [''],
      licenceDocument: [''],
      coverDocument: [''],
      email: [''],
      contactNumber: [''],
      address: [''],
      landmark: [''],
      pincode: [''],
      city: [''],
      district: [''],
      state: [''],
      country: [''],
    });
  }
  onPincodeChange(pincode: string) {
    console.log('Pincode Fn');

    this.postalCodeService.fetchaddress(pincode).subscribe((data: any) => {
      if (data && data[0] && data[0].PostOffice) {
        data[0].PostOffice.forEach((postOffice: any) => {
          this.register.patchValue({
            city: postOffice.Name,
            district: postOffice.District,
            state: postOffice.State,
            country: postOffice.Country,
          });
        });
      } else {
        Swal.fire({
          title: 'Error!',
          text: 'Pincode does not exist !!!',
          icon: 'info',
        });
      }
    });
  }

  // Image Uploading

  uploadFile(event: any): void {
    this.file = event.target.files[0];
    console.log('file', this.file);
  }

  //Validate the data of the form and send the data to the service
  doSubmit() {
    // alert('values comes');
    console.log(this.register.value);

    //check first name and last name
    let message = this.validateName(this.register.value.shopName);

    if (message != '') {
      Swal.fire({
        title: 'Error!',
        text: message,
        icon: 'error',
      });
      return;
    }

    //Check email
    message = this.validateEmail(this.register.value.email);

    if (message != '') {
      Swal.fire({
        title: 'Error!',
        text: message,
        icon: 'error',
      });
      return;
    }

    //check contact number
    message = this.validateContactNumber(this.register.value.contactNumber);

    if (message != '') {
      Swal.fire({
        title: 'Error!',
        text: message,
        icon: 'error',
      });
      return;
    }

    if (message != '') {
      Swal.fire({
        title: 'Error!',
        text: message,
        icon: 'error',
      });
      return;
    }

    //if everything is okey then call the service method

    this.shopregisterService.registerShop(this.register.value).subscribe(
      (response: any) => {
        console.log('Response from server : ', response);
        Swal.fire({
          title: 'Register Successfully!!',
          text: 'You can login now',
          icon: 'success',
        });

        //and Navigate to the login page
        this.router.navigate(['/login']);
      },
      (
        // if any  error occured while registering user
        error: any
      ) => {
        Swal.fire({
          title: 'Server Error',
          text: 'There is something wrong please try again🫣',
          icon: 'error',
        });
      }
    );

    // creating formdata to send image to backend for storing in folder structure
    let formData = new FormData();
    formData.set('file', this.file);

    this.upload.uploadImage(formData).subscribe(
      (data: any) => {
        Swal.fire({
          title: 'Good job!',
          text: 'Image  Uploaded Successfully',
          icon: 'success',
        });
      },
      (error: any) => {
        Swal.fire({
          title: 'OOPS!!!🫣',
          text: 'Unexpected Input',
          icon: 'error',
        });
      }
    );
  }

  //Validate the name fields
  validateName(shopName: any): string {
    let message = '';

    // Check if either of the fields is empty
    if (!shopName) {
      message = 'Invalid Shop Name';
      return message;
    }

    // Check if the first and last names contain at least two characters
    if (shopName.length < 2) {
      message = 'Shop name too short';
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

  checkPassword(password: any): string {
    let message = '';

    //check the password empty or not
    if (!password) {
      message = 'Both fields are required.';
      return message;
    }

    // Check if the password is between 8 to 16 characters
    if (password.length < 8 && password.length > 16) {
      message = 'Password must be between 8 to 16 characters.';
      return message;
    }

    // If all validations pass
    return message; // Return an empty string indicating success
  }

  searchByPincode(data: string) {
    console.log('Inside method' + data);
    this.onPincodeChange(data);
    // if (this.register.invalid) {
    //   return;
    // }
    // const pincode = this.register.get('pincode')?.value;
  }
}
