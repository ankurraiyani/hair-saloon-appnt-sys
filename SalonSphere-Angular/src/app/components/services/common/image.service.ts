import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ImageService {

  constructor(private http:HttpClient) { }

  uploadImage(data:any){

    return this.http.post("http://localhost:8081/shopkeeper/uploadDocument",data);
  }
}
