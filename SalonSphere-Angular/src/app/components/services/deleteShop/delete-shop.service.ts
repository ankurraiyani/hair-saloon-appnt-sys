import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cookie } from 'ng2-cookies';

@Injectable({
  providedIn: 'root'
})
export class DeleteShopService {

  constructor(private http : HttpClient) {}

  deleteShop(shopId:any){
    
const headers = new HttpHeaders().set('Authorization', 'Bearer ' + Cookie.get('token'));
    return this.http.post(`http://localhost:8081/shopkeeper/deleteshop`, shopId ,{headers});
  } 
}
