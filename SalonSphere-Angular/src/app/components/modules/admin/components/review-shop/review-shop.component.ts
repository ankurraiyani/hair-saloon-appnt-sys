import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ShopReviewService } from '../../../../services/shop-review/shop-review.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

interface shopInformation {
  ownerName: string;
  ownerEmail: string;
  shopName: string;
  shopEmail: string;
  shopContactNumber: string;
  state: string;
  district: string;
  landmark: string;
  licence: string;
}

@Component({
  selector: 'app-review-shop',
  templateUrl: './review-shop.component.html',
  styleUrl: './review-shop.component.css',
})
export class ReviewShopComponent implements OnInit {
  constructor(
    private route: ActivatedRoute,
    private shopReviewService: ShopReviewService,
    private router: Router
  ) {}

  public shops: shopInformation[] = [
    {
      ownerName: 'Aman Gupta',
      ownerEmail: 'guptaaman6264@gmail.com',
      shopName: 'Ajay Hair Salon',
      shopEmail: 'ajayhairsalon@salon.com',
      shopContactNumber: '7024859152',
      state: 'Madhya Pradesh',
      district: 'Bhopal',
      landmark: 'Ashoka garden',
      licence: 'rahulsalon.jpg',
    },
  ];

  name: string = 'aman';

  ngOnInit(): void {
    console.log('come inside the oninit');
    this.showAllShopInformation();
  }

  //get all the information of the shop which is begin review
  showAllShopInformation() {
    console.log('come inside the show method');

    //git shop Email from the localStorage
    const shopEmail = localStorage.getItem('shopEmail');

    //if shopEmail is not present in the localStorage then redirect to the view-request page
    if (shopEmail === null) {
      this.router.navigate(['/admin/view-request']);
      return;
    }

    //else call the service which  will fetch shop information using the shopEmail
    this.shopReviewService.getReviewShop(shopEmail).subscribe(
      (response: any) => {
        console.log(response);
        this.shops = response;
      },
      (error) => {
        console.log('error occured' + error);
      }
    );
  }

  //approve the shop
  public approveShop() {
    //enable the spinner
    const spinner = document.querySelector('.spinner');
    spinner?.classList.remove('disable');

    console.log('come inside the approve');

    //call the service
    this.shopReviewService.approveRequest().subscribe(
      (response) => {
        console.log(response);
        spinner?.classList.add('disable');
        Swal.fire({
          title: 'Approved',
          text: 'Shop has been approved',
          icon: 'success',
        });
        this.router.navigate(['/admin/view-request']);
      },
      (error) => {
        console.log('error occured' + error);
        spinner?.classList.add('disable');
        Swal.fire({
          title: 'Error',
          text: 'Server error occured',
          icon: 'error',
        });
      }
    );
  }

  //reject the shop
  public rejectShop() {
    //take the surity to reject the job
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!',
    }).then((result) => {
      //if the confirmation is done then reject
      if (result.isConfirmed) {
        //enable the spinner
        const spinner = document.querySelector('.spinner');
        spinner?.classList.remove('disable');

        //call the service
        this.shopReviewService.rejectRequest().subscribe(
          (response) => {
            console.log(response);
            spinner?.classList.add('disable');
            Swal.fire({
              title: 'Rejected!',
              text: 'Shop has been Rejected.',
              icon: 'success',
            });
            this.router.navigate(['/admin/view-request']);
          },
          (error) => {
            console.log('error in rejection');
            spinner?.classList.add('disable');
            Swal.fire({
              title: 'Error',
              text: 'Server error occured',
              icon: 'error',
            });
          }
        );
      }

      //else do nothing
      else {
        return;
      }
    });
  }

  public viewLicence() {
    //get image URL which has been come from backend
    const imgURL = this.shops[0].licence;
    console.log(imgURL);
    Swal.fire({
      imageUrl: `../../../../../../assets/images/${imgURL}`,
      imageAlt: "Aman's Image",
    });
  }
}
