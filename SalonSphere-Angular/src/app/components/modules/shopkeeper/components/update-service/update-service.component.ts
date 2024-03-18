import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { GetshopService } from '../../../../services/getshop/getshop.service';
import { UpdateServiceService } from '../../../../services/updateService/update-service.service';
import { error } from 'console';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-service',
  templateUrl: './update-service.component.html',
  styleUrl: './update-service.component.css'
})
export class UpdateServiceComponent {
    updateServiceForm = new FormGroup({
      serviceId:new FormControl(localStorage.getItem('serviceId')),
      serviceName: new FormControl('',Validators.required),
      servicePrice: new FormControl('',Validators.required),
      serviceDuration: new FormControl('',Validators.required),
    });

    constructor(private getshop:GetshopService, private update:UpdateServiceService, private router:Router){}

    updateservice(){
        this.update.updateService(this.updateServiceForm.value)
        .subscribe((response: any)=> {
          console.log('response from server: ',response);
          this.router.navigate(['/shopkeeper/view-shop']);
        },(error:any)=>{
          Swal.fire({
            title: 'Oops',
            text: 'Caught an Error',
            icon: 'error',
          });
        }
        );
        
    }

}
