import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { ShopRequestsService } from '../../../../services/fetch-shop-requests/shop-requests.service';


interface pandingShop {
  shopOwnerName: string;
  shopName: string;
  shopEmail: string;
  shopOwnerEmail: string;
  shopLocation: string;
}

@Component({
  selector: 'app-view-request',
  templateUrl: './view-request.component.html',
  styleUrl: './view-request.component.css'
})


export class ViewRequestComponent implements OnInit {

  count:Number=0;
  constructor(private shopRequest: ShopRequestsService,private router:Router){}
  
  public shops: pandingShop[] = [];

  ngOnInit(): void {
      this.getAllShopRequests();
      
  }

  //get all the shop which is not approved
  public getAllShopRequests(){ 
    console.log("method run");
    this.shopRequest.getShopRequests().subscribe((response:any)=>{
      console.log(response);
      this.shops = response;
    },
    error=>{
      console.log("error occure");
    })
  }

  //
  public getShopInformation(shop:any){
    console.log(shop.shopOwnerEmail);
    localStorage.setItem('ownerName', shop.shopOwnerName);
    localStorage.setItem('ownerEmail', shop.shopOwnerEmail);
    localStorage.setItem('shopName',shop.shopName);
    localStorage.setItem('shopEmail', shop.shopEmail);
    this.router.navigate(['/admin/review-shop']);
  }

}
