import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cookie } from 'ng2-cookies';

@Injectable({
  providedIn: 'root'
})
export class FetchEmployeeInfoService {

  constructor(private http: HttpClient) { }

  fetchAllEmployee(shopId:any){
    
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + Cookie.get('token'));
  
    return this.http.get(`http://localhost:8081/shopkeeper/show-all-emp/${shopId}`,{headers});
  }

  fetchEmplyeebyId(employeeId:any){
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + Cookie.get('token'));

    return this.http.get(`http://localhost:8081/shopkeeper/show-emp/${employeeId}`,{headers});
  }

}
