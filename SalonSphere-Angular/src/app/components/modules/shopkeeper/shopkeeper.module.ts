import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
// import { FormGroup,FormControl } from '@angular/forms';

import { ShopkeeperRoutingModule } from './shopkeeper-routing.module';

// MatImports

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
import {MatDialogModule} from '@angular/material/dialog';
import { MatOption } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';



import { ShopkeeperDashboardComponent } from './components/shopkeeper-dashboard/shopkeeper-dashboard.component';
import { ViewshopsComponent } from './components/viewshops/viewshops.component';
import { ShopkeeperprofileComponent } from './components/shopkeeperprofile/shopkeeperprofile.component';
import { UpdateShopComponent } from './components/update-shop/update-shop.component';
import { ViewShopInfoComponent } from './components/view-shop-info/view-shop-info.component';



@NgModule({
  declarations: [
    ShopkeeperDashboardComponent,
    ViewshopsComponent,
    ShopkeeperprofileComponent,
    UpdateShopComponent,
    ViewShopInfoComponent
  ],
  imports: [
    CommonModule,
    ShopkeeperRoutingModule,
    MatCardModule,
    ReactiveFormsModule,

    // Mat Imports
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
    MatAccordion,
    MatDialogModule,
    MatOption,
    MatSelectModule
  ]
})
export class ShopkeeperModule { }
