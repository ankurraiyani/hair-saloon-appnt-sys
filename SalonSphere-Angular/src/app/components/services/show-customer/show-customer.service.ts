import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Token } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { Cookie } from 'ng2-cookies';

@Injectable({
  providedIn: 'root'
})
export class ShowCustomerService {

  constructor(private httpClient: HttpClient) { }

  baseURL:string  = "http://localhost:8081/admin/view-customer";

  

  public getAllCustomers(){
    console.log("come inside the service");
    const token = Cookie.get('token');
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + token);
    console.log(headers);
    return  this.httpClient.get(`${this.baseURL}`, { headers });
  }
}
