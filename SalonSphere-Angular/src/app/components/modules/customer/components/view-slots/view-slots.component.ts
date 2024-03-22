import { Component } from '@angular/core';
import { NgbCalendar, NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { SlotService } from '../../../../services/slots/slot.service';
import { response } from 'express';

@Component({
  selector: 'app-view-slots',
  templateUrl: './view-slots.component.html',
  styleUrl: './view-slots.component.css',
})
export class ViewSlotsComponent {

  shopName: string | null = localStorage.getItem('shop_name');
  shopAddress: string | null = localStorage.getItem('location');

  public info = {
    shopId: localStorage.getItem('shopId'),
    shopTiming: localStorage.getItem('shopTiming'),
    serviceDuration: Number(localStorage.getItem('serviceTime'))
  };
  

  selectedDate: string;


  availableSlots: Map<string, string[]> = new Map<string, string[]>();

  constructor(private calendar: NgbCalendar, private slotService: SlotService) {
    this.selectedDate = this.getTodayDate();
    console.log(this.info);

     // Initialize availableSlots with some custom data
    //  this.availableSlots.set('User1', ['10:00-10:30', '11:00-11:30', '14:00-14:30', '15:00-15:30', '15:00-15:30', '15:00-15:30', '15:00-15:30', '15:00-15:30', '15:00-15:30', '15:00-15:30', '15:00-15:30', '15:00-15:30']);
    //  this.availableSlots.set('User2', ['09:00-09:30', '12:00-12:30', '15:00-15:30']);
    //  this.availableSlots.set('User3', ['08:00-08:30', '13:00-13:30', '16:00-16:30']);

    // call the service which will give all the available slots 
    this.slotService.getAllAvilableSlots(this.info).subscribe((response:any)=>{
      console.log("success");
        console.log(response);
        Object.keys(response).forEach(key => {
          this.availableSlots.set(key, response[key]);
        });
    },
    error=>{
      console.log("error occured"+error.message());
    })

  }

  getTodayDate(): string {
    const today = this.calendar.getToday();
    return this.formatDate(today);
  }

  formatDate(date: NgbDateStruct): string {
    return `${date.year}-${this.addLeadingZero(
      date.month
    )}-${this.addLeadingZero(date.day)}`;
  }

  addLeadingZero(value: number): string {
    return value < 10 ? '0' + value : value.toString();
  }
  
}
