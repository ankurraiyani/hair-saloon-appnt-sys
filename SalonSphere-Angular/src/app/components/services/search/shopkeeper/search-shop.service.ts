import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cookie } from 'ng2-cookies';

@Injectable({
  providedIn: 'root'
})
export class SearchShopService {

  constructor(private http:HttpClient) { }

  baseURL:string = "http://localhost:8081/shopkeeper/search/";

  searchShop(userId: string, keyword: any) {
    const token = Cookie.get('token');
    return this.http.get(`/search/${userId}/${keyword}`, {
      headers: { Authorization: `Bearer ${token}` }
    });
  }

}
