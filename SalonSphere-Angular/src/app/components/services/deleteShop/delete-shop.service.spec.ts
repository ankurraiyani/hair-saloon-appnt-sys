import { TestBed } from '@angular/core/testing';

import { DeleteShopService } from './delete-shop.service';

describe('DeleteShopService', () => {
  let service: DeleteShopService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DeleteShopService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
