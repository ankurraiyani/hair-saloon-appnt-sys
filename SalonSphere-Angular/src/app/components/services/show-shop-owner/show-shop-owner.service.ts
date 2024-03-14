import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cookie } from 'ng2-cookies';

@Injectable({
  providedIn: 'root'
})
export class ShowShopOwnerService {

  constructor(private httpClient: HttpClient) { }

  baseURL:string = "https://localhost:8081/admin/view-shopkeeper";

  public getAllShopkeeper(){
    const token = Cookie.get('token');
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + token);
    return this.httpClient.get(`${this.baseURL}`, { headers});
  }
}
