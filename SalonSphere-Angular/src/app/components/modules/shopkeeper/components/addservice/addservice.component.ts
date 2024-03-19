import { Component } from '@angular/core';
import { FormArray, FormControl, FormGroup } from '@angular/forms';
import { AddshopService } from '../../../../services/addshopservice/addshop.service';

@Component({
  selector: 'app-addservice',
  templateUrl: './addservice.component.html',
  styleUrl: './addservice.component.css'
})
export class AddserviceComponent { 

  
  data!: FormArray<any>;

  addServiceForm: FormGroup = new FormGroup({
  serviceList: new FormArray([this.getServiceFields()]),
});

constructor(private addservice:AddshopService
){}

getServiceFields(): FormGroup {
  return new FormGroup({
    shopId:new FormControl(localStorage.getItem('shopId')),
    serviceName: new FormControl(""),
    servicePrice: new FormControl(""),
    serviceDuration: new FormControl(""),
  });
}

serviceListArray() {
  this.data =  this.addServiceForm.get("serviceList") as FormArray;
  return this.data;
}

addService() {
  this.serviceListArray().push(this.getServiceFields());
}

removeService(i: number) {
  this.serviceListArray().removeAt(i);
}

getFormData() {

  this.addservice.addservice(this.data.value).subscribe((data:any)=>
  {
    console.log(data);
  })

}


}

