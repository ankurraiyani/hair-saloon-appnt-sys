import { Component, OnInit } from '@angular/core';
import { GetServiceInfoService } from '../../../../services/fetchShopServices/get-service-info.service';
import { Cookie } from 'ng2-cookies';

// Define the Service interface
interface Service {
  serviceName: any;
  servicePrice: any;
  serviceDuration: any;
}

@Component({
  selector: 'app-add-service-to-card',
  templateUrl: './add-service-to-card.component.html',
  styleUrl: './add-service-to-card.component.css',
})
export class AddServiceToCardComponent implements OnInit {
  // Define the services array using the Service interface
  services: Service[] = [];

  serviceCountMap: Map<Service, number> = new Map<Service, number>();
  shopName:any;
  totalAmount: number = 0;

  constructor(private fetchService:GetServiceInfoService, ) {}
  ngOnInit(): void {
    this.fetchService.fetchAllServices(localStorage.getItem('shopId')).subscribe((data:any)=>{
      this.services = data;
      this.shopName = localStorage.getItem('shopName');
    })
  }

  addToCart(service: Service) {
    // Print the data of the selected service to the console
    console.log(service);
  
    // Get the current count of the service from the map
    const count = this.serviceCountMap.get(service);
  
    // If the service is already in the map, increment its count
    if (count !== undefined) {
      this.serviceCountMap.set(service, count + 1);
    } else {
      // If the service is not in the map, add it with a count of 1
      this.serviceCountMap.set(service, 1);
    }
  
    // Increment the total amount
    this.totalAmount += service.servicePrice;
  }

  removeItem(product: Service) {
    // Decrease the count of the service in the map
    if (this.serviceCountMap.has(product)) {
      const count = this.serviceCountMap.get(product);
      if (count != undefined && count>1) {
        this.serviceCountMap.set(product, count - 1);
      } else {
        this.serviceCountMap.delete(product);
      }
      this.totalAmount -= product.servicePrice;
    }
  }

  addItem(product: Service) {

    const count = this.serviceCountMap.get(product);

    // Increase the count of the service in the map
    if (this.serviceCountMap.has(product) && count!=undefined) {
      this.serviceCountMap.set(product, count + 1);
    } else {
      this.serviceCountMap.set(product, 1);
    }

    this.totalAmount += product.servicePrice;
  }

}
