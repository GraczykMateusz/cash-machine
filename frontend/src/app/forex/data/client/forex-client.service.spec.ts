import { TestBed } from '@angular/core/testing';

import { ForexClientService } from './forex-client.service';

describe('ForexClientService', () => {
  let service: ForexClientService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ForexClientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
