import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ShopkeeperDashboardComponent } from './components/shopkeeper-dashboard/shopkeeper-dashboard.component';
import { shopGuardGuard } from '../../guards/shopkeeper/shop-guard.guard';
import { ViewshopsComponent } from './components/viewshops/viewshops.component';
import { ViewShopInfoComponent } from './components/view-shop-info/view-shop-info.component';

import { HomeComponent } from './home/home.component';
import { ShopregisterComponent } from './components/shopregister/shopregister.component';
import { AddserviceComponent } from './components/addservice/addservice.component';

const routes: Routes = [
  {
    path: '',
    canActivate: [shopGuardGuard],
    component: ShopkeeperDashboardComponent,
    children: [
      { path: 'view-shop', component: ViewshopsComponent },
      { path: 'home', component: HomeComponent },
      { path: 'updateshop', component: ShopregisterComponent },
      { path: 'add-shop', component: ShopregisterComponent },
      { path: '', redirectTo: '/shopkeeper/home', pathMatch: 'full' },
      { path: 'viewshopinfo', component: ViewShopInfoComponent },
      { path: 'addservice', component: AddserviceComponent },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ShopkeeperRoutingModule {}
