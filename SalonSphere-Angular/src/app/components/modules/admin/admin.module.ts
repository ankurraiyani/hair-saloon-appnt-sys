import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ViewRequestComponent } from './components/view-request/view-request.component';
import { ViewUserComponent } from './components/view-user/view-user.component';



@NgModule({
  declarations: [
    AdminDashboardComponent,
    NavbarComponent,
    ViewRequestComponent,
    HomeComponent,
    ViewUserComponent,
  ],
  imports: [
    CommonModule,
    AdminRoutingModule
  ]
})
export class AdminModule { }
