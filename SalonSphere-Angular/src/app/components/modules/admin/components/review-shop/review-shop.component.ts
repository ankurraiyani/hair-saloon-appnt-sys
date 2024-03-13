import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ShopReviewService } from '../../../../services/shop-review/shop-review.service';
import { Router } from '@angular/router';
import { response } from 'express';
import Swal from 'sweetalert2';



@Component({
  selector: 'app-review-shop',
  templateUrl: './review-shop.component.html',
  styleUrl: './review-shop.component.css'
})
export class ReviewShopComponent implements OnInit{

  constructor(private route: ActivatedRoute,private shopReviewService: ShopReviewService, private router:Router){}

  

  ownerName:string|null= localStorage.getItem('ownerName');
  ownerEmail:string|null= localStorage.getItem('ownerEmail');
  shopEmail: string|null = localStorage.getItem('shopEmail');
  shopName: string|null = '';
  shopContactNo:string|null='';
  state:string|null = '';
  district:string|null = '';
  landmark: string|null= '';
  licenseDocument:string|null='';





  ngOnInit(): void {
    console.log("come inside the oninit");
      this.showAllShopInformation();
  }

  showAllShopInformation(){
    console.log("come inside the show method");
    
    //git shop Email from the localStorage 
    const shopEmail = localStorage.getItem('shopEmail');

    //if shopEmail is not present in the localStorage then redirect to the view-request page
    if (shopEmail === null) {
      this.router.navigate(['/admin/view-request']);
      return ;
    }

    //else call the service which  will fetch shop information using the shopEmail
    this.shopReviewService.getReviewShop(shopEmail).subscribe((response:any)=>{
      console.log(response);
      this.shopName= response.shopName;
      this.shopContactNo= response.shopContactNo;
      this.state= response.state;
      this.district = response.district;
      this.landmark = response.landmark;
      this.licenseDocument = response.licenseDocument;
      
    },
    error=>{
      console.log("error occured"+ error);
    });
  }

  //approve the shop
  public approveShop(){
      console.log("come inside the approve");

      //call the service
      this.shopReviewService.approveRequest(this.shopEmail).subscribe(response=>{
        console.log(response);
        Swal.fire({
          title: 'Good Job!',
          text: 'Approved Successfully',
          icon: 'success',
        });
      },
      error=>{
        console.log("error occured"+error);
        Swal.fire({
          title: 'Error',
          text: 'Server error occured',
          icon: 'error',
        });
      })
  }

  //reject the shop
  public rejectShop(){
    console.log("come inside the reject");
    
    //call the service
    this.shopReviewService.rejectRequest(this.shopEmail).subscribe(response=>{
      console.log(response);
      Swal.fire({
        title: 'Good Job!',
        text: 'Rejected Successfully',
        icon: 'success',
      });
    },
    error=>{
      console.log("error occured"+error);
      Swal.fire({
        title: 'Error',
        text: 'Server error occured',
        icon: 'error',
      });
    })
  }

}
