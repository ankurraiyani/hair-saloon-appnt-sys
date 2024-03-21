import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cookie } from 'ng2-cookies';

@Injectable({
  providedIn: 'root'
})
export class UpdateServiceService {

  baseURL:string = "http://localhost:8081/shopkeeper/updateshop-service";

  constructor(private http:HttpClient) { }

  updateService(data:any){
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + Cookie.get('token'));
    return this.http.post(`${this.baseURL}`, data,{ headers});
  }
}
