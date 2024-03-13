import { TestBed } from '@angular/core/testing';

import { ShopReviewService } from './shop-review.service';

describe('ShopReviewService', () => {
  let service: ShopReviewService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShopReviewService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
