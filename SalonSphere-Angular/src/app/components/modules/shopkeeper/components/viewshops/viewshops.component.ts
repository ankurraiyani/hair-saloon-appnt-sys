import { Component } from '@angular/core';
import { GetshopService } from '../../../../services/getshop/getshop.service';
import { Cookie } from 'ng2-cookies';

@Component({
  selector: 'app-viewshops',
  templateUrl: './viewshops.component.html',
  styleUrl: './viewshops.component.css',
})
export class ViewshopsComponent {
  data: any[] = [];

  constructor(private getshop: GetshopService) {}

  ngOnInit(): void {
    this.getshop.getshop(Cookie.get('userId')).subscribe((data: any) => {
      console.log(data);
      this.data = data;
    });
  }
}
