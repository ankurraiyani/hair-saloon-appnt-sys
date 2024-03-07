import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { adminGuardGuard } from '../../guards/admin/admin-guard.guard';


const routes: Routes = [
  {path: '', canActivate:[adminGuardGuard],component:AdminDashboardComponent},
  {path: 'admin-dashboard', component:AdminDashboardComponent}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
