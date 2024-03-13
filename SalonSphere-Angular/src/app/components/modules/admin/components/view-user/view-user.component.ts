import { Component } from '@angular/core';

import { response } from 'express';
import { error } from 'console';
import { ShowShopOwnerService } from '../../../../services/show-shop-owner/show-shop-owner.service';
import { ShowCustomerService } from '../../../../services/show-customer/show-customer.service';

interface customer {
  fullName: string;
  contactNumber: string;
  email: string;
}

interface showOwner {
  fullName: string;
  contactNumber: string;
  email: string;
  numberOfShops: number;
}
@Component({
  selector: 'app-view-user',
  templateUrl: './view-user.component.html',
  styleUrl: './view-user.component.css',
})
export class ViewUserComponent {
  constructor(
    private customerService: ShowCustomerService,
    private shopOwnerService: ShowShopOwnerService
  ) {}

  public shopOwners: showOwner[] = [];

  public customers: customer[] = [];

  //show all the customer details to the admin
  public showCustomer() {
    console.log('come inside the show Customer');

    //enable the spinner
    const spinner = document.querySelector('.spinner');
    spinner?.classList.remove('disable');

    this.customerService.getAllCustomers().subscribe(
      (response: any) => {
        //add and remove the disable class from the tables
        const customerTable = document.querySelector('.customer-table');
        const ownerTable = document.querySelector('.owner-table');
        customerTable?.classList.remove('disable');
        ownerTable?.classList.add('disable');
        console.log(response);
        this.customers = response;
        spinner?.classList.add('disable');
      },
      (error) => {
        spinner?.classList.add('disable');
        console.log('error occur' + error);
      }
    );
  }

  //show all the shop owner details fot the admin
  public showShopOwner() {
    console.log('come inside the show shop owner');
    //enable the spinner
    const spinner = document.querySelector('.spinner');
    spinner?.classList.remove('disable');

    this.shopOwnerService.getAllShopkeeper().subscribe(
      (response: any) => {
        console.log(response);

        //add and remove the disable class from the tables
        const customerTable = document.querySelector('.customer-table');
        const ownerTable = document.querySelector('.owner-table');
        ownerTable?.classList.remove('disable');
        customerTable?.classList.add('disable');
        this.shopOwners = response;
        spinner?.classList.add('disable');
      },
      (error) => {
        spinner?.classList.add('disable');
        console.log('error occured' + error);
      }
    );
  }
}
