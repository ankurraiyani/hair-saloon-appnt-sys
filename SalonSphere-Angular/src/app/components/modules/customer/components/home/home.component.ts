import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  constructor(private router:Router){}

  exploreService(serviceName:string,  serviceType: string) {

    //set the service name into the localstorage
    localStorage.setItem('serviceName', serviceName);
    localStorage.setItem('class',serviceType);

    //navigate the user into the view-shops page
    this.router.navigate(['/customer/view-shops']);

  }
}
