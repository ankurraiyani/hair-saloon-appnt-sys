import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private httpClient: HttpClient) { }

  baseURL:string = 'http://localhost:8081/register';

  registerUser(userData:any){
    console.log("come inside the service method");
    console.log(userData);
    console.log(`${this.baseURL}`);
    return this.httpClient.post(`${this.baseURL}`, userData);
  }
}
