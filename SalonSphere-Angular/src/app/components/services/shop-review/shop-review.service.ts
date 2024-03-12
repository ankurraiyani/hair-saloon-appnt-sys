import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cookie } from 'ng2-cookies';

@Injectable({
  providedIn: 'root',
})
export class ShopReviewService {
  constructor(private httpClient: HttpClient) {}

  baseURL: string = 'http://localhost:8081/admin/view-requests/review-shop';

  //get the shop which is being Review by the admin
  public getReviewShop(shopEmailId: string) {
    console.log('come inside the service');

    //set the token in header
    const token = Cookie.get('token');
    const headers = new HttpHeaders().set(
      'Authorization',
      'Bearer ' + token
    );
    return this.httpClient.post(`${this.baseURL}`, shopEmailId, { headers });

  }

  //URL for Approval
  approveURL: string = 'http://localhost:8081/admin/view-requests/approve-request';

  //approve the shop which i begin review by the admin
  public approveRequest() {
    console.log('come inside approve-requests');

    //set the token in header
    const token = Cookie.get('token');
    const headers = new HttpHeaders().set(
      'Authorization',
      'Bearer ' + token
    );
    return this.httpClient.get(`${this.approveURL}`, { headers });
  }

  //URL for Rejection
  rejectURL: string = 'http://localhost:8081/admin/view-requests/reject-request';

  //approve the shop which i begin review by the admin
  public rejectRequest() {
    console.log('come inside approve-requests');

    //set the token in header
    const token = Cookie.get('token');
    const headers = new HttpHeaders().set(
      'Authorization',
      'Bearer ' + token
    );
    return this.httpClient.get(`${this.rejectURL}`, { headers });
  }


}
