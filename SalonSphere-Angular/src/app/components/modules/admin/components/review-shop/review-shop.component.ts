import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

interface shopInformation{
  ownerName:string,
  ownerEmail:string,
  shopName: string,
  shopEmail: string,
  shopContactNumber: string,
  state: string,
  district: string,
  landmark: string,
  licence: string
}

@Component({
  selector: 'app-review-shop',
  templateUrl: './review-shop.component.html',
  styleUrl: './review-shop.component.css'
})
export class ReviewShopComponent implements OnInit{

  constructor(private route: ActivatedRoute){}

  public shops: shopInformation []= [{
    ownerName: "Aman Gupta",
    ownerEmail: "guptaaman6264@gmail.com",
    shopName: "Ajay Hair Salon",
    shopEmail: "ajayhairsalon@salon.com",
    shopContactNumber: "7024859152",
    state: "Madhya Pradesh",
    district: "Bhopal",
    landmark: 'Ashoka garden',
    licence: 'licence'
  }];

  name:string ='aman';

  ngOnInit(): void {
    console.log("come inside the oninit");
      this.showAllShopInformation();
  }

  showAllShopInformation(){
    console.log("come inside the show method");
    
  }


}
