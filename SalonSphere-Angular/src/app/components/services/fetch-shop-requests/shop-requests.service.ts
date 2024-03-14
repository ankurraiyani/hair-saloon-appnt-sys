import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cookie } from 'ng2-cookies';

@Injectable({
  providedIn: 'root'
})

export class ShopRequestsService {

  //baseURL for server
  baseURL = 'http://localhost:8081/admin/shop-requests';

  constructor(private httpClient:HttpClient) { }

  //fetch all the shop- request data from the server
  public getShopRequests(){
    console.log("come inside the shop-request-service method");
    const token = Cookie.get('token');
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + token);
    return this.httpClient.get(`${this.baseURL}`, {headers});
  }

  
}
