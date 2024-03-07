import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient: HttpClient) { }

  baseURL:string = 'http://localhost:8080/login';

  loginUser(loginData:any){
    console.log("come inside the service method");
    console.log(loginData);
    console.log(`${this.baseURL}`);
    return this.httpClient.post(`${this.baseURL}`, loginData);
  }
}
