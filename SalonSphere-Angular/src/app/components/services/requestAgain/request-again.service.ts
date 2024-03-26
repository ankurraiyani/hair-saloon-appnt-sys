import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cookie } from 'ng2-cookies';

@Injectable({
  providedIn: 'root'
})
export class RequestAgainService {

  baseURL:string = "http://localhost:8081/shopkeeper/updateshop";
  url2:string = "http://localhost:8081/shopkeeper/changeStatus";
  constructor(private http:HttpClient) { }

  updateShop(data:any){

    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + Cookie.get('token'));
    return this.http.post(`${this.baseURL}`, data,{ headers});
  }

  changeStatus(data:any){
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + Cookie.get('token'));
    return this.http.post(`${this.url2}`, data,{ headers})
  }
}
