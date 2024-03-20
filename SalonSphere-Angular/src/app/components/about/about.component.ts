import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { AddshopService } from '../services/addshopservice/addshop.service';
import { Cookie } from 'ng2-cookies';
import { GetshopService } from '../services/getshop/getshop.service';
import { FetchshopInfoService } from '../services/fetchshopInfo/fetchshop-info.service';
import { PincodeService } from '../services/common/pincode.service';
import { ShopregisterService } from '../services/shopregister/shopregister.service';
import { ImageService } from '../services/common/image.service';
import { UpdateShopService } from '../services/updateShop/update-shop.service';
import { DeleteShopService } from '../services/deleteShop/delete-shop.service';
import { GetServiceInfoService } from '../services/fetchShopServices/get-service-info.service';
import {MatTableModule} from '@angular/material/table';


interface shopData {
  shopName: string;
  shopEmail: string;
  createdDate: string;
}

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrl: './about.component.css'
})
export class AboutComponent {
  data: any[] = [];

  constructor(private getshop: GetshopService) {}

  ngOnInit(): void {
    this.getshop.getshop(Cookie.get('userId')).subscribe((data: any) => {
      this.data = data;
      
    });
  }

  showinfo(email: string,shopId:any) {
    console.log('This Shop is ' + shopId);
    localStorage.setItem('shopEmail', email);
    localStorage.setItem('shopId', shopId);
    
    
  }
}
