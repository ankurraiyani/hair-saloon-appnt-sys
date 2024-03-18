import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cookie } from 'ng2-cookies';

@Injectable({
  providedIn: 'root'
})
export class AddshopService {

  constructor(private http : HttpClient) { }

  addservice(data:any[]){

    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + Cookie.get('token')); 

    return this.http.post('http://localhost:8081/shopkeeper/add-service',data,{headers})
  }
}
