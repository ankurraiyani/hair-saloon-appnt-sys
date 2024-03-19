import { Component } from '@angular/core';
import { GetServiceInfoService } from '../../../../services/fetchShopServices/get-service-info.service';
import { Cookie } from 'ng2-cookies';

@Component({
  selector: 'app-view-shop-services',
  templateUrl: './view-shop-services.component.html',
  styleUrl: './view-shop-services.component.css'
})
export class ViewShopServicesComponent {
  data: any[] = [];

  constructor(private getShopServices:GetServiceInfoService) {}

  ngOnInit(): void {
    this.getShopServices.fetchAllServices(localStorage.getItem('shopId')).subscribe((data: any) => {
      
      this.data = data;
      console.log(data);
      
    });
  }
saveId(serviceId:any){
  console.log(serviceId)
  localStorage.setItem('serviceId',serviceId);
}


}
