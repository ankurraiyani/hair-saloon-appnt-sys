import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Cookie } from 'ng2-cookies';
import Swal from 'sweetalert2';
import { ImageService } from '../../../../services/common/image.service';
import { PincodeService } from '../../../../services/common/pincode.service';
import { ShopregisterService } from '../../../../services/shopregister/shopregister.service';
import { Router } from '@angular/router';
import { GetshopService } from '../../../../services/getshop/getshop.service';

@Component({
  selector: 'app-update-shop',
  templateUrl: './update-shop.component.html',
  styleUrl: './update-shop.component.css',
})
export class UpdateShopComponent implements OnInit {
  update = new FormGroup({
    userId: new FormControl(Cookie.get('userId')),
    shopName: new FormControl('', Validators.required),
    licenceNo: new FormControl('', Validators.required),
    licenceDocument: new FormControl(''),
    coverImage: new FormControl(''),
    shopEmail: new FormControl('', Validators.required),
    shopContactNo: new FormControl('', Validators.required),
    address: new FormControl('', Validators.required),
    landmark: new FormControl('', Validators.required),
    pincode: new FormControl('', Validators.required),
    shopCity: new FormControl('', Validators.required),
    district: new FormControl('', Validators.required),
    state: new FormControl('', Validators.required),
  });
  constructor(private getshop: GetshopService) {}
  ngOnInit(): void {}

  updateShop() {
  }
}
