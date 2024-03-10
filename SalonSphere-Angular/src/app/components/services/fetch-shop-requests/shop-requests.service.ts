import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class ShopRequestsService {

  //baseURL for server
  baseURL = 'http://localhost:8081/shop-requests';

  constructor(private httpClient:HttpClient) { }

  //fetch all the shop- request data from the server
  public getShopRequests(){
    console.log("come inside the shop-request-service method");
    return this.httpClient.get(`${this.baseURL}`);
  }

  
}
