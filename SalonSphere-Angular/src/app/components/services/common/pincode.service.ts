import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PincodeService {

  constructor(private http : HttpClient) { }

  baseURL:string = 'https://api.postalpincode.in/pincode/';

  fetchaddress(pincode:any){
    console.log("come inside the service method");
    console.log(`${this.baseURL}`+pincode);
    return this.http.get(`${this.baseURL}`+pincode);
  }

  
}
