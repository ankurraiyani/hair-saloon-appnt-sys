import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';
import { CustomerDashboardComponent } from './components/customer-dashboard/customer-dashboard.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HeaderComponent } from './components/header/header.component';
import { ViewShopsComponent } from './components/view-shops/view-shops.component';
import { AddServiceToCardComponent } from './components/add-service-to-card/add-service-to-card.component';


@NgModule({
  declarations: [
    CustomerDashboardComponent,
    HomeComponent,
    NavbarComponent,
    HeaderComponent,
    ViewShopsComponent,
    AddServiceToCardComponent
  ],
  imports: [
    CommonModule,
    CustomerRoutingModule
  ]
})
export class CustomerModule { }
