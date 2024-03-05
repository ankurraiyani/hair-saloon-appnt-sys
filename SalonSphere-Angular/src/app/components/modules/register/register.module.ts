import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RegisterRoutingModule } from './register-routing.module';
import { CustomerRegisterComponent } from './component/customer-register/customer-register.component';
import { ShopRegisterComponent } from './component/shop-register/shop-register.component';
import { RegisterComponent } from './component/register/register.component';
import { NavbarComponent } from '../../navbar/navbar.component';


@NgModule({
  declarations: [
    CustomerRegisterComponent,
    ShopRegisterComponent,
    RegisterComponent
  ],
  imports: [
    CommonModule,
    RegisterRoutingModule
  ]
})
export class RegisterModule { }
