import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ShopregisterService {

  constructor(private http:HttpClient) { }

  registerShop(data:any){
    return this.http.get('https://localhost:8080/shopkeeper/addshop',data);
  }
}
