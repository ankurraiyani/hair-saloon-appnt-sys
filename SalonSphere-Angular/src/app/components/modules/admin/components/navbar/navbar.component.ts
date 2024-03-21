import { Component, ElementRef } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { LogoutService } from '../../../../services/logout/logout.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css',
})
export class NavbarComponent {
  // constructor(private elementRef: ElementRef) {
  //   // Accessing DOM elements and adding event listener inside the constructor
  //   const menuicn = this.elementRef.nativeElement.querySelector(".menuicn");
  //   const nav = this.elementRef.nativeElement.querySelector(".navcontainer");

  //   menuicn.addEventListener("click", () => {
  //     nav.classList.toggle("navclose");
  //   });
  // }

  //  menuicn.addEventListener("click", () => {
  //       nav.classList.toggle("navclose");
  //   });

  flag:boolean=false;

  constructor(private router: Router, private logoutService:LogoutService) {}

  public navigateViewUsers() {

    //remove the active class
    const hover: NodeListOf<Element> = document.querySelectorAll('.nav-option');
    hover.forEach((element) => {
      element.classList.remove('active');
    });

    //add the active class to current clicked button
    const home = document.querySelector('.option2');
    home?.classList.add('active');

    this.router.navigate(['/admin/view-user']);

  }

  expansion() {
    const hover: NodeListOf<Element> = document.querySelectorAll('.nav-option');
    hover.forEach((element) => {
      element.classList.remove('active');
    });
    if (this.flag == false) {
      this.flag = true;
      return;
    } else {
      this.flag = false;
      return;
    }
  }

  

  public navigateViewRequests() {

    //remove the active class
    const hover: NodeListOf<Element> = document.querySelectorAll('.nav-option');
    hover.forEach((element) => {
      element.classList.remove('active');
    });

    //add the active class to current clicked button
    const home = document.querySelector('.option4');
    home?.classList.add('active');

    this.router.navigate(['/admin/view-request']);


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

    this.router.navigate(['/admin/home']);

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
      title: "Are you sure?",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Yes, Logout !"
    }).then((result) => {

      //if confirmation is done then call the logout service
      if (result.isConfirmed) {
        this.logoutService.logout();
        this.router.navigate(['/login']);
      }

      //else do nothing
      else{
        return ;
      }

    });
  }

}
