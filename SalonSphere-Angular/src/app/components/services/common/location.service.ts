import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  constructor(private httpClient: HttpClient) { }

  //Location api URL
  apiURL:string = 'https://ipapi.co/json/';

  getLocation(){
    return this.httpClient.get(`${this.apiURL}`);
  }
}
