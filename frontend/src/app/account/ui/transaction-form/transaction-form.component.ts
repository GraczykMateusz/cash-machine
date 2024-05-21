import { Component, inject } from '@angular/core';
import { NgbDateStruct, NgbInputDatepicker } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { ModalService } from '../../../shared/modal/modal.service';
import { ContactsComponent } from '../contacts/contacts.component';

@Component({
  selector: 'app-transaction-form',
  standalone: true,
  imports: [
    NgbInputDatepicker,
    FormsModule
  ],
  templateUrl: './transaction-form.component.html',
  styleUrl: './transaction-form.component.scss'
})
export class TransactionFormComponent {
  
  private readonly modalService: ModalService = inject(ModalService);
  
  model?: NgbDateStruct;
  
  openContacts() {
    this.modalService.open<ContactsComponent>(ContactsComponent);
  }
}
