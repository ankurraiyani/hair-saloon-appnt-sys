import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import path from 'path';
import { CustomerRegisterComponent } from './component/customer-register/customer-register.component';
import { ShopRegisterComponent } from './component/shop-register/shop-register.component';
import { RegisterComponent } from './component/register/register.component';

const routes: Routes = [
  {
    path: '', component: RegisterComponent

  },
  {
    path:"shop-register", component: ShopRegisterComponent
  },
  {
    path:"customer-register", component: CustomerRegisterComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RegisterRoutingModule { }
