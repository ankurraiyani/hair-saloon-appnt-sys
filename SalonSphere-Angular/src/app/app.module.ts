import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { ReactiveFormsModule } from '@angular/forms';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AboutComponent } from './components/about/about.component';
import { ContactComponent } from './components/contact/contact.component';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ServiceComponent } from './components/service/service.component';
import { RegisterComponent } from './components/register/register.component';
import { RegisterService } from './components/services/register/register.service';

//Material Imports

import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider';
import { MatAccordion, MatExpansionModule } from '@angular/material/expansion';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTooltipModule } from '@angular/material/tooltip';











import { HttpClientModule } from '@angular/common/http';
import { LoginService } from './components/services/login/login.service';
import { AuthserviceService } from './components/services/common/authservice.service';
import { ShopRequestsService } from './components/services/fetch-shop-requests/shop-requests.service';
import { ShowShopOwnerService } from './components/services/show-shop-owner/show-shop-owner.service';
import { ShowCustomerService } from './components/services/show-customer/show-customer.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    NavbarComponent,
    ForgotPasswordComponent,
    ServiceComponent,
    ContactComponent,
    AboutComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    ReactiveFormsModule,
    HttpClientModule,
    // Material Imports
    MatTooltipModule,
    MatButtonModule,  
    MatCardModule,
    MatSidenavModule,
    MatIconModule,
    MatToolbarModule,
    MatMenuModule,
    MatFormFieldModule,
    MatDividerModule,
    MatTableModule,
    MatExpansionModule,
    MatAccordion
    

    




    
  ],
  providers: [
    provideClientHydration(),
    provideAnimationsAsync(),
    RegisterService,
    LoginService,
    AuthserviceService,
    ShopRequestsService,
    ShowShopOwnerService,
    ShowCustomerService,
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
