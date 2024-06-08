import { TestBed } from '@angular/core/testing';

import { AccountNumberService } from './account-number.service';

describe('AccountNumberService', () => {
  let service: AccountNumberService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AccountNumberService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
