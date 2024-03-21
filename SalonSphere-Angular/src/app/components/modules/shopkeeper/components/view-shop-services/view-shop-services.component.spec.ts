import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewShopServicesComponent } from './view-shop-services.component';

describe('ViewShopServicesComponent', () => {
  let component: ViewShopServicesComponent;
  let fixture: ComponentFixture<ViewShopServicesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ViewShopServicesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViewShopServicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
