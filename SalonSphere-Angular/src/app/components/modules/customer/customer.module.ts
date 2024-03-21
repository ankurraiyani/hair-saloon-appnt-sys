import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';
import { CustomerDashboardComponent } from './components/customer-dashboard/customer-dashboard.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HeaderComponent } from './components/header/header.component';
import { ViewShopsComponent } from './components/view-shops/view-shops.component';
import { AddServiceToCardComponent } from './components/add-service-to-card/add-service-to-card.component';
import { ViewSlotsComponent } from './components/view-slots/view-slots.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatInputModule } from '@angular/material/input';
import { NgbDatepickerModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    CustomerDashboardComponent,
    HomeComponent,
    NavbarComponent,
    HeaderComponent,
    ViewShopsComponent,
    AddServiceToCardComponent,
    ViewSlotsComponent
  ],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    MatDatepickerModule,
    MatInputModule,
    NgbDatepickerModule,
    FormsModule
  ]
})
export class CustomerModule { }
