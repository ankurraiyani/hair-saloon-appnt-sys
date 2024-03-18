import { TestBed } from '@angular/core/testing';

import { FetchshopInfoService } from './fetchshop-info.service';

describe('FetchshopInfoService', () => {
  let service: FetchshopInfoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FetchshopInfoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
