import { Component } from '@angular/core';
import { ShowCustomerService } from '../../../../services/show-customer/show-customer.service';
import { response } from 'express';
import { error } from 'console';
import { ShowShopOwnerService } from '../../../../services/show-shop-owner/show-shop-owner.service';

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

  constructor(private customerService: ShowCustomerService, private  shopOwnerService :ShowShopOwnerService) {}

  public shopOwners: showOwner[] =[{
    fullName: "aman",
    contactNumber: "7024859152",
    email: "guasjdg;oj",
    numberOfShops: 4
  }];

  public customers: customer[] = [{
    fullName: "aman",
    contactNumber: "70248591520",
    email:"aman@gmail.com"
  }];

  //show all the customer details to the admin
  public showCustomer() {
    console.log("come inside the show Customer");
    this.customerService.getAllCustomers().subscribe((response:any)=>{

      //add and remove the disable class from the tables
      const customerTable = document.querySelector('.customer-table');
      const ownerTable = document.querySelector('.owner-table');
      customerTable?.classList.remove('disable');
      ownerTable?.classList.add('disable');
        console.log(response);
        this.customers=response;
    },
    error=>{
        console.log("error occur"+ error);
    });
    
  }


  //show all the shop owner details fot the admin
  public showShopOwner() {
    console.log("come inside the show shop owner");
    
    this.shopOwnerService.getAllShopkeeper().subscribe((response:any)=>{
      console.log(response);

      //add and remove the disable class from the tables
      const customerTable = document.querySelector('.customer-table');
      const ownerTable = document.querySelector('.owner-table');
      customerTable?.classList.add('disable');
      ownerTable?.classList.remove('disable');
      this.shopOwners=response;
    },
    error=>{
      console.log("error occured" + error);
    })
  }
}
