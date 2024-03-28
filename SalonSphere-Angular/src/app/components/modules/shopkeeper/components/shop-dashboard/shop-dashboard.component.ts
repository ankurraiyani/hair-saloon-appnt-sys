import { Component, OnInit } from '@angular/core';
import { GetServiceInfoService } from '../../../../services/fetchShopServices/get-service-info.service';
import { FetchshopInfoService } from '../../../../services/fetchshopInfo/fetchshop-info.service';
import Swal from 'sweetalert2';
import { DeleteServiceService } from '../../../../services/deleteService/delete-service.service';
import { FetchReviewsService } from '../../../../services/viewReviews/fetch-reviews.service';
import { FetchEmployeeInfoService} from '../../../../services/fetchShopEmployee/fetch-employee-info.service';

@Component({
  selector: 'app-shop-dashboard',
  templateUrl: './shop-dashboard.component.html',
  styleUrl: './shop-dashboard.component.css',
})
export class ShopDashboardComponent  implements OnInit{
  constructor(
    private fetchshopInfo: FetchshopInfoService,
    private getShopServices: GetServiceInfoService,
    private removeService: DeleteServiceService,
    private reviewService: FetchReviewsService,
    private fetchShopEmployees: FetchEmployeeInfoService
  ) {}

  data: any[] = [];
  reviews: any[] = [];
  empData: any[]= [];

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

        console.log("Hello This is get Shop By email",data);
      });

      this.reviewService.getReviews(localStorage.getItem('shopId')).subscribe(
        (data: any) => {
          this.reviews = data;
          console.log(data)
        },
        (error: any) => {
          console.log(error);
        }
      );

        // this.fetchShopEmployees
        // .fetchAllEmployee(localStorage.getItem('shopId'))
        // .subscribe((empData:any)=>{
        //   this.empData = empData;
        //   console.log("Hello this is Shop Employees by shopId ",empData);
        // })

    }
  
  saveId(serviceId: any) {
    console.log(serviceId);
    localStorage.setItem('serviceId', serviceId);
  }

  saveEmpId(employeeId: any) {
    console.log(employeeId);
    localStorage.setItem('employeeId', employeeId);
  }

  getFilledStars(rating: number): number[] {
    return Array(Math.floor(rating)).fill(0);
  }

  // Function to return array of empty stars
  getEmptyStars(rating: number): number[] {
    return Array(5 - Math.floor(rating)).fill(0);
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
