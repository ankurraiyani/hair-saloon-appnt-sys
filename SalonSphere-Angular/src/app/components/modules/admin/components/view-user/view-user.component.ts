import { Component } from '@angular/core';
import { ShowCustomerService } from '../../../../services/show-customer/show-customer.service';
import { response } from 'express';
import { error } from 'console';

interface customer{
  fullName:string,
  contactNumber: string,
  email: string
}

interface showOwner{
  fullName: string,
  contactNumber: string,
  email: string ,
  numberOfShops: number
}
@Component({
  selector: 'app-view-user',
  templateUrl: './view-user.component.html',
  styleUrl: './view-user.component.css'
})
export class ViewUserComponent {

  constructor(private customerService: ShowCustomerService, private  ownerService :ShowCustomerService) {}

  public showCustomer() {
    console.log("come inside the show Customer");
    this.customerService.getAllCustomers().subscribe(response=>{
        console.log(response);
    },
    error=>{
        console.log("error occur"+ error);
    });
    
  }

  public showShopOwner() {
    console.log("come inside the show shop owner");
  }
}
