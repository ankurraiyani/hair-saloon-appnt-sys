import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cookie } from 'ng2-cookies';

@Injectable({
  providedIn: 'root'
})
export class GetServiceInfoService {

  constructor(private http : HttpClient) { }

  fetchAllServices(shopId:any){
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + Cookie.get('token'));

    return this.http.get(`http://localhost:8081/shopkeeper/showservices/${shopId}`,{headers});
  }
}
