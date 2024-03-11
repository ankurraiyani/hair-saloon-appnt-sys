import { TestBed } from '@angular/core/testing';

import { ShopregisterService } from './shopregister.service';

describe('ShopregisterService', () => {
  let service: ShopregisterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShopregisterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
