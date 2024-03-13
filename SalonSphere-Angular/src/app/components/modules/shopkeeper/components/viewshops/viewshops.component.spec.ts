import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewshopsComponent } from './viewshops.component';

describe('ViewshopsComponent', () => {
  let component: ViewshopsComponent;
  let fixture: ComponentFixture<ViewshopsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ViewshopsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViewshopsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
