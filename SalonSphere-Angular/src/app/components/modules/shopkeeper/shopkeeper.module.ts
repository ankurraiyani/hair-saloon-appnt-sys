import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ShopkeeperRoutingModule } from './shopkeeper-routing.module';
import { DashboardComponent } from './components/dashboard/dashboard.component';


import {MatCardModule} from '@angular/material/card';



@NgModule({
  declarations: [
    DashboardComponent
  ],
  imports: [
    CommonModule,
    ShopkeeperRoutingModule,
    MatCardModule
  ]
})
export class ShopkeeperModule { }
