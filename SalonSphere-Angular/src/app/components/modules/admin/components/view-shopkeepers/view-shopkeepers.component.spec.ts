import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewShopkeepersComponent } from './view-shopkeepers.component';

describe('ViewShopkeepersComponent', () => {
  let component: ViewShopkeepersComponent;
  let fixture: ComponentFixture<ViewShopkeepersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ViewShopkeepersComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViewShopkeepersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
