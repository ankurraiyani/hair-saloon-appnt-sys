import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddServiceToCardComponent } from './add-service-to-card.component';

describe('AddServiceToCardComponent', () => {
  let component: AddServiceToCardComponent;
  let fixture: ComponentFixture<AddServiceToCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AddServiceToCardComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddServiceToCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
