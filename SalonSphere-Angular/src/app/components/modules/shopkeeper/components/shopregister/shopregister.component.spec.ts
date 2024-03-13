import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopregisterComponent } from './shopregister.component';

describe('ShopregisterComponent', () => {
  let component: ShopregisterComponent;
  let fixture: ComponentFixture<ShopregisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ShopregisterComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ShopregisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
