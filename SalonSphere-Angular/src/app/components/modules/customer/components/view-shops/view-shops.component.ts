import { Component, OnInit } from '@angular/core';
import { ShowShopsService } from '../../../../services/customer/show-shops.service';

import Swal from 'sweetalert2';
import { FetchshopInfoService } from '../../../../services/fetchshopInfo/fetchshop-info.service';


interface shop {
  shopName: string;
  location: string;
  coverImage: string;
  timeDuration: string;
  price: number;
  rating:any;
  shopId:any;
}
@Component({
  selector: 'app-view-shops',
  templateUrl: './view-shops.component.html',
  styleUrl: './view-shops.component.css',
})
export class ViewShopsComponent implements OnInit {
  constructor(private customerService: ShowShopsService) {}

  //variable which track the dropdown lists
  serviceName:any = null;
  range:any = null;
  distance:any = null;
  city:any = localStorage.getItem('location');


  public shops: shop[] = [];

  //show the list of the shop on besis of the city when ever the page will load
  ngOnInit(): void {
    this.city = localStorage.getItem('location');
    this.showShopByCity(this.city);
  }

  getShopId(shopId:any,shopName:any){
    localStorage.setItem('shopId',shopId);
    localStorage.setItem('shopName',shopName)
  }

  //call the service method and get all the shops by using city
  public showShopByCity(location: any) {
    this.customerService.showShopsByCity(location).subscribe(
      (response: any) => {
        console.log(response);
        if (response == null) {
          Swal.fire({
            title: 'Not Found',
            text: 'There is no any shop in this city',
            icon: 'error',
          });
        } else {
          this.shops = response;
        }
      },
      (error) => {
        console.log('error occure');
      }
    );
  }

  //DOM Menuplation for Servive Dropdown
  showServiceDropdown() {

    const selected = document.querySelector('.service-selected');
    const optionsContainer = document.querySelector('.service');
    const optionsList = document.querySelectorAll('.service-option');

    if (selected && optionsContainer)
      optionsList.forEach((o) => {
        o.addEventListener('click', () => {
          const lebel = o.querySelector('label');
          if (lebel) {
            selected.innerHTML = lebel.innerHTML;
            this.serviceName = lebel.innerHTML;
          }
          optionsContainer.classList.remove('active');

          //call the dropdownFilter method which filter the shop by using service Name
          this.dropdownFilter(this.serviceName, this.range, this.distance,this.city);

          setTimeout(() => {
            optionsContainer.classList.add('active');
          }, 1000);
        });
      });
  }

  //DOM Menuplation for range Dropdown
  showrangeDropdown() {

    const selected = document.querySelector('.range-selected');
    const optionsContainer = document.querySelector('.range');
    const optionsList = document.querySelectorAll('.range-option');

    if (selected && optionsContainer)
      optionsList.forEach((o) => {
        console.log('aman');
        o.addEventListener('click', () => {
          const lebel = o.querySelector('label');
          if (lebel) {
            selected.innerHTML = lebel.innerHTML;
            this.range = lebel.innerHTML;
          }
          optionsContainer.classList.remove('active');

          //call the dropdownFilter method which filter the shop by using range
          this.dropdownFilter(this.serviceName, this.range, this.distance, this.city);

          setTimeout(() => {
            optionsContainer.classList.add('active');
          }, 1000);
        });
      });
  }

  //DOM menuplation for distance Dropdown
  showdistanceDropdown() {

    const selected = document.querySelector('.distance-selected');
    const optionsContainer = document.querySelector('.distance');
    const optionsList = document.querySelectorAll('.distance-option');

    if (selected && optionsContainer)
      optionsList.forEach((o) => {
        console.log('aman');
        o.addEventListener('click', () => {
          const lebel = o.querySelector('label');
          if (lebel) {
            selected.innerHTML = lebel.innerHTML;
            this.distance= lebel.innerHTML;
          }
          optionsContainer.classList.remove('active');

          
          //call the dropdownFilter method which filter the shop by using distance
          this.dropdownFilter(this.serviceName, this.range, this.distance, this.city);

          setTimeout(() => {
            optionsContainer.classList.add('active');
          }, 1000);
        });
      });
  }
  dropdownFilter(serviceName: any, range: any, distance: any, city: any) {
    this.customerService.filterShops(serviceName, range, distance, city).subscribe(
      (response: any) => {
        console.log(response);
        console.log("Aman Bhai")
        if (!response || response.length === 0) {
          this.shops = [];
        } else {
          this.shops = response;
        }
      },
      (error) => {
        console.log("Error occurred");
      }
    );
  }
}
