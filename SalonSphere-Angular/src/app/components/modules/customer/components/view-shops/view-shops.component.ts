import { Component, OnInit } from '@angular/core';
import { ShowShopsService } from '../../../../services/customer/show-shops.service';

import Swal from 'sweetalert2';


interface shop {
  shopName: string;
  location: string;
  coverImage: string;
  timeDuration: string;
  price: number;
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
  renge:any = null;
  distence:any = null;
  city:any = localStorage.getItem('location');


  public shops: shop[] = [];

  //show the list of the shop on besis of the city when ever the page will load
  ngOnInit(): void {
    this.city = localStorage.getItem('location');

    //just for testing
    localStorage.setItem('shopTiming', '10:30-18:30');
    localStorage.setItem('shopId', 'c5b4f80f-7dd8-42c2-b2d4-4f8074487871');
    localStorage.setItem('serviceTime', '30');

    this.showShopByCity(this.city);
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
          this.dropdownFilter(this.serviceName, this.renge, this.distence,this.city);

          setTimeout(() => {
            optionsContainer.classList.add('active');
          }, 1000);
        });
      });
  }

  //DOM Menuplation for Renge Dropdown
  showRengeDropdown() {

    const selected = document.querySelector('.renge-selected');
    const optionsContainer = document.querySelector('.renge');
    const optionsList = document.querySelectorAll('.renge-option');

    if (selected && optionsContainer)
      optionsList.forEach((o) => {
        console.log('aman');
        o.addEventListener('click', () => {
          const lebel = o.querySelector('label');
          if (lebel) {
            selected.innerHTML = lebel.innerHTML;
            this.renge = lebel.innerHTML;
          }
          optionsContainer.classList.remove('active');

          //call the dropdownFilter method which filter the shop by using Renge
          this.dropdownFilter(this.serviceName, this.renge, this.distence, this.city);

          setTimeout(() => {
            optionsContainer.classList.add('active');
          }, 1000);
        });
      });
  }

  //DOM menuplation for Distence Dropdown
  showDistenceDropdown() {

    const selected = document.querySelector('.distence-selected');
    const optionsContainer = document.querySelector('.distence');
    const optionsList = document.querySelectorAll('.distence-option');

    if (selected && optionsContainer)
      optionsList.forEach((o) => {
        console.log('aman');
        o.addEventListener('click', () => {
          const lebel = o.querySelector('label');
          if (lebel) {
            selected.innerHTML = lebel.innerHTML;
            this.distence= lebel.innerHTML;
          }
          optionsContainer.classList.remove('active');

          
          //call the dropdownFilter method which filter the shop by using distence
          this.dropdownFilter(this.serviceName, this.renge, this.distence, this.city);

          setTimeout(() => {
            optionsContainer.classList.add('active');
          }, 1000);
        });
      });
  }
  dropdownFilter(serviceName: any, renge: any, distence: any, city: any) {
    this.customerService.filterShops(serviceName, renge, distence, city).subscribe(
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
