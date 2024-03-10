import { TestBed } from '@angular/core/testing';

import { ShopRequestsService } from './shop-requests.service';

describe('ShopRequestsService', () => {
  let service: ShopRequestsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShopRequestsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
