import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cookie } from 'ng2-cookies';

@Injectable({
  providedIn: 'root'
})
export class SlotService {

  //baseURL for api calling

  baseURL:string = 'http://localhost:8081/view-slots';

  constructor(private httpClient:HttpClient) { }
  
    getAllAvilableSlots(info:any){
      console.log("come inside the service");
      console.log(info);
      const token = Cookie.get('token');
      const headers = new HttpHeaders().set('Authorization', 'Bearer ' +token);
      console.log(headers);
      return this.httpClient.post(`${this.baseURL}`, info,{headers});
    }
}
