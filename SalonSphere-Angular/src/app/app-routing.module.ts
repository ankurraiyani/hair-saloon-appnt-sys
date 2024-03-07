import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { ServiceComponent } from './components/service/service.component';
import { AboutComponent } from './components/about/about.component';
import { ContactComponent } from './components/contact/contact.component';
import { RegisterComponent } from './components/register/register.component';



const routes: Routes = [
  {path:"home", component:HomeComponent},
  {path:"login", component: LoginComponent},
  {path:"forgot-password", component: ForgotPasswordComponent},
  {path:"service", component:ServiceComponent},
  {path:"about", component: AboutComponent},
  {path:"contact",component:ContactComponent},
  {path:"register", component: RegisterComponent},
  {path:"", component: HomeComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
