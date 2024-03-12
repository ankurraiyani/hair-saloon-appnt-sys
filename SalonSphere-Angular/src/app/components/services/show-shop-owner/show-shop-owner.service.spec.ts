import { TestBed } from '@angular/core/testing';

import { ShowShopOwnerService } from './show-shop-owner.service';

describe('ShowShopOwnerService', () => {
  let service: ShowShopOwnerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShowShopOwnerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
