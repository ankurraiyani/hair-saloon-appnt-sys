import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ShopkeeperDashboardComponent } from './components/shopkeeper-dashboard/shopkeeper-dashboard.component';
import { shopGuardGuard } from '../../guards/shopkeeper/shop-guard.guard';
import { ViewshopsComponent } from './components/viewshops/viewshops.component';
import { AddshopserviceComponent } from './components/addshopservice/addshopservice.component';
import { UpdateshopserviceComponent } from './components/updateshopservice/updateshopservice.component';
import { ShopregisterComponent } from './components/shopregister/shopregister.component';

const routes: Routes = [
  {path: '', canActivate:[shopGuardGuard],component: ShopkeeperDashboardComponent},
  {path: 'shopkeeper-dashboard', component: ShopkeeperDashboardComponent},
  {path: 'view-shop', component: ViewshopsComponent},
  {path: 'addshop', component: ShopregisterComponent},
  {path: 'addshopservise', component: AddshopserviceComponent},
  {path: 'updateshopService', component: UpdateshopserviceComponent},
 
  {path: '', canActivate:[shopGuardGuard],component: ShopkeeperDashboardComponent,
  children: [
  {path: 'view-shop', component: ViewshopsComponent},
  {path: 'addshopservise', component: AddshopserviceComponent},
  {path: 'updateshopService', component: UpdateshopserviceComponent},

  ],
}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ShopkeeperRoutingModule { }
