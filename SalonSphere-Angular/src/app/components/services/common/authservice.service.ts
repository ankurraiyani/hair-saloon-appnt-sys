import { Injectable } from '@angular/core';
import { Cookie } from 'ng2-cookies';
import { stringify } from 'querystring';

@Injectable({
  providedIn: 'root'
})
export class AuthserviceService {

  constructor() { }

  isLogin():boolean{

    //if the current user is login or not
    if(Cookie.get('token')!=null){
      return true;
    }
    return false;
  }

  getRole() : string {
    
    //get the role of the current user
    let role = Cookie.get('role');
    console.log("Get Role From cookie:"+role);
    return role;
  }
}
