import { TestBed } from '@angular/core/testing';

import { UpdateShopService } from './update-shop.service';

describe('UpdateShopService', () => {
  let service: UpdateShopService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdateShopService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
