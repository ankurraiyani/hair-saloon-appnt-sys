import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerDashboardComponent } from './components/customer-dashboard/customer-dashboard.component';
import { customerGuardGuard } from '../../guards/customer/customer-guard.guard';

const routes: Routes = [
  {path:'', canActivate:[customerGuardGuard], component: CustomerDashboardComponent},
  {path:'customer-dashboard', component: CustomerDashboardComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule { }
