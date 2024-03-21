import { Component, OnInit } from '@angular/core';
import { ShowShopOwnerService } from '../../../../services/show-shop-owner/show-shop-owner.service';

interface showOwner {
  fullName: string;
  contactNumber: string;
  email: string;
  numberOfShops: number;
}

@Component({
  selector: 'app-view-shopkeepers',
  templateUrl: './view-shopkeepers.component.html',
  styleUrl: './view-shopkeepers.component.css',
})
export class ViewShopkeepersComponent implements OnInit {
  public shopOwners: showOwner[] = [];
  constructor(private shopOwnerService: ShowShopOwnerService) {}
  ngOnInit(): void {
    this.showShopOwner();
  }

  public showShopOwner() {
    console.log('come inside the show shop owner');
    //enable the spinner
    const spinner = document.querySelector('.spinner');
    spinner?.classList.remove('disable');

    this.shopOwnerService.getAllShopkeeper().subscribe(
      (response: any) => {
        console.log(response);

        //add and remove the disable class from the tables
        const customerTable = document.querySelector('.customer-table');
        const ownerTable = document.querySelector('.owner-table');
        ownerTable?.classList.remove('disable');
        customerTable?.classList.add('disable');
        this.shopOwners = response;
        spinner?.classList.add('disable');
      },
      (error) => {
        spinner?.classList.add('disable');
        console.log('error occured' + error);
      }
    );
  }
}
