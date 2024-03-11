import { Component, OnInit } from '@angular/core';
import { ShopRequestsService } from '../../../../services/fetch-shop-requests/shop-requests.service';
import { response } from 'express';
import { error } from 'console';

interface pandingShop {
  ownerName: string;
  shopName: string;
  contactNumber: string;
  email: string;
  location: string;
}

@Component({
  selector: 'app-view-request',
  templateUrl: './view-request.component.html',
  styleUrl: './view-request.component.css'
})


export class ViewRequestComponent implements OnInit {

  count:Number=0;
  constructor(private shopRequest: ShopRequestsService){}
  
  public shops: pandingShop[] = [];

  ngOnInit(): void {
      this.getAllShopRequests();
      
  }

  public getAllShopRequests(){ 
    console.log("method run");
    this.shopRequest.getShopRequests().subscribe(response=>{
      console.log(response);
    },
    error=>{
      console.log("error occure");
    })
  }

  counter(){
    return this.count;
  }
}
