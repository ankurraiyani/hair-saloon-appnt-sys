import { Component, OnInit } from '@angular/core';
import { GetServiceInfoService } from '../../../../services/fetchShopServices/get-service-info.service';
import { FetchshopInfoService } from '../../../../services/fetchshopInfo/fetchshop-info.service';

@Component({
  selector: 'app-shop-dashboard',
  templateUrl: './shop-dashboard.component.html',
  styleUrl: './shop-dashboard.component.css',
})
export class ShopDashboardComponent  implements OnInit{
  constructor(
    private fetchshopInfo: FetchshopInfoService,
    private getShopServices: GetServiceInfoService
  ) {}

  data: any[] = [];

  shopData: any;
    amount:any;
  ngOnInit(): void {
    this.fetchshopInfo
      .fetchshopInfo(localStorage.getItem('shopEmail'))
      .subscribe((data: any) => {
        this.shopData = data;
        console.log(this.shopData.shopId);
      });

    this.getShopServices
      .fetchAllServices(localStorage.getItem('shopId'))
      .subscribe((data: any) => {
        this.data = data;
        this.amount = data.servicePrice;

        console.log(data);
      });
    }
    

  saveId(serviceId: any) {
    console.log(serviceId);
    localStorage.setItem('serviceId', serviceId);
  }
}
