import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { ViewRequestComponent } from './components/view-request/view-request.component';
import { HomeComponent } from './components/home/home.component';
import { ViewUserComponent } from './components/view-user/view-user.component';



const routes: Routes = [
  {
    path: '',
    component: AdminDashboardComponent,
    children: [{path: 'home', component: HomeComponent},
      { path: 'view-request', component: ViewRequestComponent},
      { path: 'view-user', component: ViewUserComponent},
    {path: '', redirectTo: '/admin/home', pathMatch: 'full'}
  ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AdminRoutingModule {}
