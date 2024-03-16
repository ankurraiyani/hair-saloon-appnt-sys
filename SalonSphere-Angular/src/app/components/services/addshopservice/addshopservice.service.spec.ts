import { TestBed } from '@angular/core/testing';

import { AddshopserviceService } from './addshopservice.service';

describe('AddshopserviceService', () => {
  let service: AddshopserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddshopserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
