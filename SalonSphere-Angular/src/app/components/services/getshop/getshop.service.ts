import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cookie } from 'ng2-cookies';

@Injectable({
  providedIn: 'root'
})
export class GetshopService {

  // Url Subject to change
  private baseURL: String = 'http://localhost:8081';

  constructor(private http : HttpClient) {}

  getshop(data:any){
    console.log("come inside the get shop");
    const token = Cookie.get('token');
    console.log(token);
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + token);
    return this.http.get(`${this.baseURL}/shopkeeper/show-shop/${data}`,{ headers });
  }

}
