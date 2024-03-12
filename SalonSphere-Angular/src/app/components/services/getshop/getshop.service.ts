import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GetshopService {

  // Url Subject to change
  private baseURL: String = 'http://localhost:8081';

  constructor(private http : HttpClient) {}

  getshop(data:any){
    return this.http.get(`${this.baseURL}/shopkeeper/show-shop`,data);
  }

}
