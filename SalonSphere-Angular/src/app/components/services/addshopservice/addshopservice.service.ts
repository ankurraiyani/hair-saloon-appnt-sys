import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cookie } from 'ng2-cookies';
import { catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AddshopserviceService {

  constructor(private http: HttpClient) {}

  // addshopservice(data:any[]){
  //   const headers = new HttpHeaders().set('Authorization', 'Bearer '+ Cookie.get('token') );

  //   console.log("add shop service data inside service",data);

  //   const data2 = JSON.stringify(data);
  //   console.log(data2);
  //   console.log("addshop service hedder",headers)

  //   return this.http.post('http://localhost:8081/shopkeeper/add-service', data, {
  //     headers
  //   });
  // }

  


  addshopservice(data: any[]) {
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + Cookie.get('token'));
    console.log("add shop service data inside service",data);
    return this.http.post('http://localhost:8081/shopkeeper/add-service', data, { headers });
  }
  



}
