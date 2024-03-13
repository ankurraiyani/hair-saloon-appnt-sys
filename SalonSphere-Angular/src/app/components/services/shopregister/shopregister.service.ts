import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cookie } from 'ng2-cookies';

@Injectable({
  providedIn: 'root'
})
export class ShopregisterService {

  constructor(private http:HttpClient) { }

  registerShop(data:any){
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + Cookie.get('token'));

    console.log("Yeh hai headder",headers);
    return this.http.post('http://localhost:8081/shopkeeper/addshop', data, {headers} );
    // return this.http.post('http://localhost:8081/shopkeeper/addshop',data);
  }
}
