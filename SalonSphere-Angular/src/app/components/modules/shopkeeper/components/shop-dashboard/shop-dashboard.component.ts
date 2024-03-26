import { Component, OnInit } from '@angular/core';
import { GetServiceInfoService } from '../../../../services/fetchShopServices/get-service-info.service';
import { FetchshopInfoService } from '../../../../services/fetchshopInfo/fetchshop-info.service';
import Swal from 'sweetalert2';
import { DeleteServiceService } from '../../../../services/deleteService/delete-service.service';

@Component({
  selector: 'app-shop-dashboard',
  templateUrl: './shop-dashboard.component.html',
  styleUrl: './shop-dashboard.component.css',
})
export class ShopDashboardComponent  implements OnInit{
  constructor(
    private fetchshopInfo: FetchshopInfoService,
    private getShopServices: GetServiceInfoService,
    private removeService: DeleteServiceService
  ) {}

  data: any[] = [];

  shopData: any;
    amount:any;
  ngOnInit(): void {
    this.fetchshopInfo
      .fetchshopInfo(localStorage.getItem('shopEmail'))
      .subscribe((data: any) => {
        this.shopData = data;
        console.log(this.shopData.coverImage);
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

  deleteService() {
    Swal.fire({
      title: 'Are you sure you want to delete this Service?',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it',
      cancelButtonText: 'Cancel',
    }).then((result) => {
      if (result.isConfirmed) {
        this.confirmDeleteService();
      }
    });
  }

  confirmDeleteService() {
    this.removeService
      .deleteService(localStorage.getItem('serviceId'))
      .subscribe(
        (data: any) => {
          // Handle successful deletion
          Swal.fire('Service deleted!', '', 'success');
        },
        (error) => {
          // Handle error
          Swal.fire('Error', 'Failed to delete the service', 'error');
        }
      );
  }

}
