import { TestBed } from '@angular/core/testing';

import { ModalService } from './modal.service';
import { ProcessingModalComponent } from '../../ui/processing-modal/processing-modal.component';

describe('ModalService', () => {
  let service: ModalService;
  
  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ModalService);
  });
  
  it('should be created', () => {
    expect(service).toBeTruthy();
  });
  
  it('should open modal', () => {
    service.open<ProcessingModalComponent>(ProcessingModalComponent);
    expect(service.hasOpenModals).toBeTruthy();
  });
  
});
