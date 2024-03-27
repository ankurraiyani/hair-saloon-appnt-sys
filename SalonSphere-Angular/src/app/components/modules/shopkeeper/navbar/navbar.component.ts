import { Component } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { LogoutService } from '../../../services/logout/logout.service';
import { Cookie } from 'ng2-cookies';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css',
})
export class NavbarComponent {
  shopkeeperName: any = Cookie.get('name').split(' ')[0];
  flag = false;

  constructor(private router: Router, private logoutService: LogoutService) {}

  public navigateAddShop() {
   

    this.router.navigate(['/shopkeeper/add-shop']);
  }

  expansion() {
     //remove the active class
     const hover: NodeListOf<Element> = document.querySelectorAll('.nav-option');
     hover.forEach((element) => {
       element.classList.remove('active');
     });
 
     //add the active class to current clicked button
     const home = document.querySelector('.option2');
     home?.classList.add('active');
    if (this.flag == false) {
      this.flag = true;
      return;
    } else {
      this.flag = false;
      return;
    }
  }

  public navigateViewShop() {
    //remove the active class
    const hover: NodeListOf<Element> = document.querySelectorAll('.nav-option');
    hover.forEach((element) => {
      element.classList.remove('active');
    });

    //add the active class to current clicked button
    const home = document.querySelector('.option3');
    home?.classList.add('active');

    this.router.navigate(['/shopkeeper/view-shop']);
  }

  public navigateHome() {
    //remove the active class
    const hover: NodeListOf<Element> = document.querySelectorAll('.nav-option');
    hover.forEach((element) => {
      element.classList.remove('active');
    });

    //add the active class to current clicked button
    const home = document.querySelector('.option1');
    home?.classList.add('active');

    this.router.navigate(['/shopkeeper/home']);
  }

  public navigateLogout() {
    //remove the active class
    const hover: NodeListOf<Element> = document.querySelectorAll('.nav-option');
    hover.forEach((element) => {
      element.classList.remove('active');
    });

    //add the active class to current clicked button
    const home = document.querySelector('.option7');
    home?.classList.add('active');

    Swal.fire({
      title: 'Are you sure?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, Logout !',
    }).then((result) => {
      //if confirmation is done then call the logout service
      if (result.isConfirmed) {
        this.logoutService.logout();
        this.router.navigate(['/login']);
      }

      //else do nothing
      else {
        return;
      }
    });
  }
}
