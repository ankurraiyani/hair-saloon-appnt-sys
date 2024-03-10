import { TestBed } from '@angular/core/testing';

import { ShowCustomerService } from './show-customer.service';

describe('ShowCustomerService', () => {
  let service: ShowCustomerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShowCustomerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
