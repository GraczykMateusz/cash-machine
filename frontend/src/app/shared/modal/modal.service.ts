import { inject, Injectable } from '@angular/core';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { NgbModalOptions } from '@ng-bootstrap/ng-bootstrap/modal/modal-config';

@Injectable({
  providedIn: 'root'
})
export class ModalService {
  
  private readonly ngbModal: NgbModal = inject(NgbModal);
  
  open = <T>(content: unknown, options?: NgbModalOptions): TypedNgbModalRef<T> => this.ngbModal.open(content, {
    backdrop: 'static',
    backdropClass: 'progress-modal-backdrop',
    keyboard: false,
    ...options
  }) as TypedNgbModalRef<T>;
  
  dismissAll = (reason?: unknown): void => this.ngbModal.dismissAll(reason);
  
  get hasOpenModals(): boolean {
    return this.ngbModal.hasOpenModals();
  }
}

export declare class TypedNgbModalRef<T> extends NgbModalRef {
  override get componentInstance(): T;
}
