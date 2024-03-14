import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewShopInfoComponent } from './view-shop-info.component';

describe('ViewShopInfoComponent', () => {
  let component: ViewShopInfoComponent;
  let fixture: ComponentFixture<ViewShopInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ViewShopInfoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViewShopInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
