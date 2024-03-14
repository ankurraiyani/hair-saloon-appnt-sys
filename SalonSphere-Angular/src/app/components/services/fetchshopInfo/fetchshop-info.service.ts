import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cookie } from 'ng2-cookies';

@Injectable({
  providedIn: 'root'
})
export class FetchshopInfoService {
  baseURL: string = 'http://localhost:8081/shokeeper/getshopbyemail';
  constructor(private http:HttpClient) { }

  fetchshopInfo(email:any){

    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + Cookie.get('token'));

    return this.http.post(`${this.baseURL}/${email}`,{ headers });
  }
}
