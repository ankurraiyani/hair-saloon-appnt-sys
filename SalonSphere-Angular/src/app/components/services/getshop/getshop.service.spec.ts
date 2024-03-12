import { TestBed } from '@angular/core/testing';

import { GetshopService } from './getshop.service';

describe('GetshopService', () => {
  let service: GetshopService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetshopService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
