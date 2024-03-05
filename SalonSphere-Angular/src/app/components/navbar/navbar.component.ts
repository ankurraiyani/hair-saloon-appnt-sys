import { Component } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
constructor(){
  // let menuIcon = document.querySelector('.menuIcon') as HTMLElement;
  // let nav = document.querySelector('.overlay-menu') as HTMLElement;

  // menuIcon.addEventListener('click', () => {
  //     if (nav.style.transform != 'translateX(0%)') {
  //         nav.style.transform = 'translateX(0%)';
  //         nav.style.transition = 'transform 0.2s ease-out';
  //     } else { 
  //         nav.style.transform = 'translateX(-100%)';
  //         nav.style.transition = 'transform 0.2s ease-out';
  //     }
  // });


  // // Toggle Menu Icon ========================================
  // let toggleIcon = document.querySelector('.menuIcon') as HTMLElement;

  // toggleIcon.addEventListener('click', () => {
  //     if (toggleIcon.className != 'menuIcon toggle') {
  //         toggleIcon.className += ' toggle';
  //     } else {
  //         toggleIcon.className = 'menuIcon';
  //     }
  // });
}
}
