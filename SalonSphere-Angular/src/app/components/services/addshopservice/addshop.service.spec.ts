import { TestBed } from '@angular/core/testing';

import { AddshopService } from './addshop.service';

describe('AddshopService', () => {
  let service: AddshopService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddshopService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
