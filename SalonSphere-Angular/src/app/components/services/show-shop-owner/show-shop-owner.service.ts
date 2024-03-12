import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ShowShopOwnerService {

  constructor(private httpClient: HttpClient) { }

  baseURL:string = "http://localhost:8081/view-shopkeeper";

  public getAllShopkeeper(){
    return this.httpClient.get(`${this.baseURL}`);
  }
}
