import { Component, OnInit } from '@angular/core';
import { LocationService } from '../../../../services/common/location.service';
import { response } from 'express';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit{

  constructor(private locationService: LocationService){}

  private customerCity:string ='';
  private customerCountry:string = '';

  ngOnInit(): void {
    
    //call location service which give the user current location
    this.locationService.getLocation().subscribe((response:any)=>
    {
      this.customerCity=response.city;
      this.customerCountry= response.country_name;

      //save the location in local storage also
      localStorage.setItem('location',this.customerCity);

      const option = document.createElement('option');
      option.textContent= this.customerCity+', '+this.customerCountry;
      const dropDown = document.querySelector('.dropdown');

      //remove the all the options from the dropdown
      while(dropDown?.firstChild){
      dropDown?.firstChild.remove();
      }

      //add current location of the customer in dropdown
      dropDown?.appendChild(option);
      console.log(this.customerCity);
    })
  }



}
