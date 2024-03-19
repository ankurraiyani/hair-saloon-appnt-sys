import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { GetshopService } from '../../../../services/getshop/getshop.service';
import { UpdateServiceService } from '../../../../services/updateService/update-service.service';
import { error } from 'console';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';
import { GetServiceInfoService } from '../../../../services/fetchShopServices/get-service-info.service';
import { DeleteServiceService } from '../../../../services/deleteService/delete-service.service';

@Component({
  selector: 'app-update-service',
  templateUrl: './update-service.component.html',
  styleUrl: './update-service.component.css',
})
export class UpdateServiceComponent implements OnInit {
  updateServiceForm = new FormGroup({
    serviceId: new FormControl(localStorage.getItem('serviceId')),
    shopId: new FormControl(localStorage.getItem('shopId')),
    serviceName: new FormControl('', Validators.required),
    servicePrice: new FormControl('', Validators.required),
    serviceDuration: new FormControl('', Validators.required),
    createDate: new FormControl(''),
  });

  constructor(
    private getshop: GetshopService,
    private update: UpdateServiceService,
    private router: Router,
    private getService: GetServiceInfoService,
    private removeService: DeleteServiceService
  ) {}
  ngOnInit(): void {
    this.getService
      .fetchServicebyId(localStorage.getItem('serviceId'))
      .subscribe((data: any) => {
        this.updateServiceForm.patchValue({
          serviceName: data.serviceName,
          servicePrice: data.servicePrice,
          serviceDuration: data.serviceDuration,
          createDate: data.createDate,
        });
      });
  }
  goBack(){
    window.history.back();
  }
  

  updateservice() {
    this.update.updateService(this.updateServiceForm.value).subscribe(
      (response: any) => {
        console.log('response from server: ', response);
        Swal.fire({
          title: 'Updated',
          text: 'Shop Updated Succesfully',
          icon: 'success',
        });
        this.router.navigate(['/shopkeeper/view-shop']);
      },
      (error: any) => {
        Swal.fire({
          title: 'Oops',
          text: 'Caught an Error',
          icon: 'error',
        });
      }
    );
  }

  deleteService() {
    Swal.fire({
      title: 'Are you sure you want to delete this Service?',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it',
      cancelButtonText: 'Cancel',
    }).then((result) => {
      if (result.isConfirmed) {
        this.confirmDeleteService();
      }
    });
  }

  confirmDeleteService() {
    this.removeService
      .deleteService(localStorage.getItem('serviceId'))
      .subscribe(
        (data: any) => {
          // Handle successful deletion
          Swal.fire('Service deleted!', '', 'success');
        },
        (error) => {
          // Handle error
          Swal.fire('Error', 'Failed to delete the service', 'error');
        }
      );
  }
}
