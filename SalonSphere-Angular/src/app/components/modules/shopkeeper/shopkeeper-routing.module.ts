import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ShopkeeperDashboardComponent } from './components/shopkeeper-dashboard/shopkeeper-dashboard.component';
import { shopGuardGuard } from '../../guards/shopkeeper/shop-guard.guard';
import { ShopregisterComponent } from '../../shopregister/shopregister.component';

const routes: Routes = [
  {path: '', canActivate:[shopGuardGuard],component: ShopkeeperDashboardComponent},
  {path: 'shopkeepr-dashboard', component: ShopkeeperDashboardComponent},
  {path: 'addshop', component: ShopregisterComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ShopkeeperRoutingModule { }
