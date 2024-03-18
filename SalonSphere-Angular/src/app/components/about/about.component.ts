import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrl: './about.component.css'
})
export class AboutComponent { 
  addServiceForm: FormGroup = new FormGroup({
  serviceList: new FormArray([this.getStudentFields()]),
});

constructor(){}

getStudentFields(): FormGroup {
  return new FormGroup({
    serviceName: new FormControl(""),
    servicePrice: new FormControl(""),
    serviceDuration: new FormControl(""),
  });
}

serviceListArray() {
  return this.addServiceForm.get("serviceList") as FormArray;
}

addService() {
  this.serviceListArray().push(this.getStudentFields());
}

removeService(i: number) {
  this.serviceListArray().removeAt(i);
}

getFormData() {
}


}
