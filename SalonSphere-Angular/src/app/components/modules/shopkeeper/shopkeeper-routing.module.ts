import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ShopkeeperDashboardComponent } from './components/shopkeeper-dashboard/shopkeeper-dashboard.component';
import { shopGuardGuard } from '../../guards/shopkeeper/shop-guard.guard';
import { ShopregisterComponent } from './components/shopregister/shopregister.component';
import { ViewshopsComponent } from './components/viewshops/viewshops.component';
import { ViewShopInfoComponent } from './components/view-shop-info/view-shop-info.component';

const routes: Routes = [
  {
    path: '',
    canActivate: [shopGuardGuard],
    component: ShopkeeperDashboardComponent,
  },
  { path: 'shopkeeper-dashboard', component: ShopkeeperDashboardComponent },
  { path: 'view-shop', component: ViewshopsComponent },
  { path: 'updateshop', component: ShopregisterComponent },
  { path: 'addshop', component: ShopregisterComponent },
  { path: 'viewshopinfo', component: ViewShopInfoComponent },
  {
    path: '',
    canActivate: [shopGuardGuard],
    component: ShopkeeperDashboardComponent,
    children: [
      { path: 'shopkeeper-dashboard', component: ShopkeeperDashboardComponent },
      { path: 'view-shop', component: ViewshopsComponent },
      { path: 'updateshop', component: ShopregisterComponent },
      { path: 'addshop', component: ShopregisterComponent },
      { path: 'viewshopinfo', component: ViewShopInfoComponent },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ShopkeeperRoutingModule {}
