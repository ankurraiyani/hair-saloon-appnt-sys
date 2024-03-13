import { Component, OnInit } from '@angular/core';
import { GetshopService } from '../../../../services/getshop/getshop.service';
import { Cookie } from 'ng2-cookies';

@Component({
  selector: 'app-shopkeeper-dashboard',
  templateUrl: './shopkeeper-dashboard.component.html',
  styleUrl: './shopkeeper-dashboard.component.css'
})
export class ShopkeeperDashboardComponent implements OnInit {

  data:any[]=[]

  constructor(private getshop:GetshopService,){

  }


  ngOnInit(): void {
    this.getshop.getshop(Cookie.get('userId')).subscribe((data:any)=>
     { console.log(data)
      this.data = data;

      }
      )
    }

}
