import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ShopkeeperRoutingModule } from './shopkeeper-routing.module';



import {MatCardModule} from '@angular/material/card';
import { ShopkeeperDashboardComponent } from './components/shopkeeper-dashboard/shopkeeper-dashboard.component';



@NgModule({
  declarations: [
    ShopkeeperDashboardComponent
  ],
  imports: [
    CommonModule,
    ShopkeeperRoutingModule,
    MatCardModule
  ]
})
export class ShopkeeperModule { }
