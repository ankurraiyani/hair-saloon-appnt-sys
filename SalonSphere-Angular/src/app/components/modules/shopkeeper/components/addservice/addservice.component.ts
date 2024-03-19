import { Component } from '@angular/core';
import { FormArray, FormControl, FormGroup } from '@angular/forms';
import { AddshopService } from '../../../../services/addshopservice/addshop.service';
import Swal from 'sweetalert2';

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
goBack(){
  window.history.back();
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
    
    Swal.fire({
      title: 'Success',
      text: 'Service(s) Added Successfully',
      icon: 'success',
    });
  },(error:any)=>{
    Swal.fire({
      title: 'Please Try Again',
      text: 'Error caught while adding Service(s)',
      icon: 'error',
    });
  }
  )
  
}


}

