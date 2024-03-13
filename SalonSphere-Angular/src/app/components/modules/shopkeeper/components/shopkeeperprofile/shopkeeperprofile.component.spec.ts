import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopkeeperprofileComponent } from './shopkeeperprofile.component';

describe('ShopkeeperprofileComponent', () => {
  let component: ShopkeeperprofileComponent;
  let fixture: ComponentFixture<ShopkeeperprofileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ShopkeeperprofileComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ShopkeeperprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
