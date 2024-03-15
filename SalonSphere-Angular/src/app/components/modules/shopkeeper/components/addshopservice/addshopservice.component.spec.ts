import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddshopserviceComponent } from './addshopservice.component';

describe('AddshopserviceComponent', () => {
  let component: AddshopserviceComponent;
  let fixture: ComponentFixture<AddshopserviceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AddshopserviceComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddshopserviceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
