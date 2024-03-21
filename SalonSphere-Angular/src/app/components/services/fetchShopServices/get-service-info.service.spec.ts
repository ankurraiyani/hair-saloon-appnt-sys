import { TestBed } from '@angular/core/testing';

import { GetServiceInfoService } from './get-service-info.service';

describe('GetServiceInfoService', () => {
  let service: GetServiceInfoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetServiceInfoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
