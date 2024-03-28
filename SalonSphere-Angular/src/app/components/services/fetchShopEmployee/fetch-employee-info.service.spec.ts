import { TestBed } from '@angular/core/testing';

import { FetchEmployeeInfoService } from './fetch-employee-info.service';

describe('FetchEmpplyeeInfoService', () => {
  let service: FetchEmployeeInfoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FetchEmployeeInfoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
