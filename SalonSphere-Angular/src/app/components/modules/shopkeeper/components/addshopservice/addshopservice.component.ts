import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormArray, FormControl, FormsModule } from '@angular/forms';
import Swal from 'sweetalert2';
import { Router, RouterModule } from '@angular/router';
import { AddshopserviceService } from '../../../../services/addshopservice/addshopservice.service';
import { HttpErrorResponse } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-addshopservice',
  templateUrl: './addshopservice.component.html',
  styleUrls: ['./addshopservice.component.css'],
})
export class AddshopserviceComponent {
  
} 