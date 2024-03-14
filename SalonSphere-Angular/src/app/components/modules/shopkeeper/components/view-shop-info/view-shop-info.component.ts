import { Component, OnInit } from '@angular/core';
import { FetchshopInfoService } from '../../../../services/fetchshopInfo/fetchshop-info.service';

interface shopdata {
  shopName: string;
  pincode: string;
  state: string;
  district: string;
  landmark: string;
  address: string;
  licenceNo: string;
  shopStatus: string;
  coverImage: string;
  shopEmail: string;
  shopContactNo: string;
  shopCity: string;
}

@Component({
  selector: 'app-view-shop-info',
  templateUrl: './view-shop-info.component.html',
  styleUrl: './view-shop-info.component.css',
})
export class ViewShopInfoComponent implements OnInit {
  shopinfo: shopdata[] = [];

  constructor(private fetchshopInfo: FetchshopInfoService) {}

  ngOnInit(): void {
    this.fetchshopInfo
      .fetchshopInfo(localStorage.getItem('shopEmail'))
      .subscribe((data: any) => {
         this.shopinfo = data;

         console.log(data)
      });
  }
}
