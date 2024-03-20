import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cookie } from 'ng2-cookies';

@Injectable({
  providedIn: 'root'
})
export class DeleteServiceService {

  constructor(private http:HttpClient) { }

  deleteService(serviceId:any){
    
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + Cookie.get('token'));
    console.log("Ye hheader hai",headers)
    console.log("Ye hheader hai",serviceId)
    

        return this.http.post(`http://localhost:8081/shopkeeper/deleteshop-service/${serviceId}`,{},{headers});
      } 
}
