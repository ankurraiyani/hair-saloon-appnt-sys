import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateshopserviceComponent } from './updateshopservice.component';

describe('UpdateshopserviceComponent', () => {
  let component: UpdateshopserviceComponent;
  let fixture: ComponentFixture<UpdateshopserviceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UpdateshopserviceComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UpdateshopserviceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
