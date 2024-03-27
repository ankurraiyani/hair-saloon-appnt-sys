import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cookie } from 'ng2-cookies';

@Injectable({
  providedIn: 'root'
})
export class FetchReviewsService {
  baseURL:string = "http://localhost:8081/customer/get-all-feedback";

constructor(private http:HttpClient) { }
getReviews(shopId:any){
  const headers = new HttpHeaders().set('Authorization', 'Bearer ' + Cookie.get('token'));

  console.log("FeedBack Header",headers)
  console.log("FeedBack value",shopId)
  return this.http.get(`${this.baseURL}/${shopId}`,{ headers});
}
}
