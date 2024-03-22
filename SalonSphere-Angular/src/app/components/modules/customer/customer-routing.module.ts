import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerDashboardComponent } from './components/customer-dashboard/customer-dashboard.component';
import { customerGuardGuard } from '../../guards/customer/customer-guard.guard';
import { HomeComponent } from './components/home/home.component';
import { ViewShopsComponent } from './components/view-shops/view-shops.component';
import { AddServiceToCardComponent } from './components/add-service-to-card/add-service-to-card.component';
import { ViewSlotsComponent } from './components/view-slots/view-slots.component';

const routes: Routes = [
  {path:'', component: CustomerDashboardComponent,
  children :[
  {
    path:'home', component: HomeComponent
  },
  {
    path: 'view-shops', component: ViewShopsComponent
  },{
    path: 'add-service-to-card', component:AddServiceToCardComponent
  },
  {
    path: 'view-slots', component: ViewSlotsComponent
  },
  {path:'', redirectTo: '/customer/home', pathMatch: 'full'}
  ],
}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule { }
