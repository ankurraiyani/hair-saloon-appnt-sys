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
    console.log('come inside the service get review shop');

    //set the token in header
    const token = Cookie.get('token');
    console.log(token);
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + token);
    const params = { shopEmailId: shopEmailId };
    console.log(headers);
    console.log(params);
    return this.httpClient.post(`${this.baseURL}`,shopEmailId,{ headers });

  }

  //URL for Approval
  approveURL: string = 'http://localhost:8081/admin/view-requests/approve-request';

  //approve the shop which i begin review by the admin
  public approveRequest(shopEmail:any) {
    console.log('come inside approve-requests');

    //set the token in header
    const token = Cookie.get('token');
    const headers = new HttpHeaders().set(
      'Authorization',
      'Bearer ' + token
    );
    const params = { shopEmail: shopEmail };
    return this.httpClient.post(`${this.approveURL}`, shopEmail, { headers });
  }

  //URL for Rejection
  rejectURL: string = 'http://localhost:8081/admin/view-requests/reject-request';

  //approve the shop which i begin review by the admin
  public rejectRequest(shopEmail:any) {
    console.log('come inside approve-requests');

    //set the token in header
    const token = Cookie.get('token');
    const headers = new HttpHeaders().set(
      'Authorization',
      'Bearer ' + token
    );

    const params = { shopEmail: shopEmail };
    return this.httpClient.post(`${this.rejectURL}`, shopEmail, { headers });
  }


}
