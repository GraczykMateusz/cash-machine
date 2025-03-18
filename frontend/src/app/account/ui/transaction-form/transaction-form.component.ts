import { Component, inject } from '@angular/core';
import { NgbInputDatepicker } from '@ng-bootstrap/ng-bootstrap';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ModalService } from '../../../shared/modal/modal.service';
import { ContactsComponent } from '../contacts/contacts.component';
import { first } from 'rxjs';
import { UserContact } from '../contacts/data/user-contact';

@Component({
    selector: 'app-transaction-form',
    imports: [
        NgbInputDatepicker,
        FormsModule,
        ReactiveFormsModule
    ],
    templateUrl: './transaction-form.component.html',
    styleUrl: './transaction-form.component.scss'
})
export class TransactionFormComponent {
  
  private readonly modalService: ModalService = inject(ModalService);
  
  readonly transactionFormData = new FormGroup({
    accountNumber: new FormControl(''),
    title: new FormControl(''),
    amount: new FormControl(''),
    transactionDate: new FormControl('')
  });
  
  // model?: NgbDateStruct;
  
  openContacts() {
    this.modalService.open<ContactsComponent>(ContactsComponent)
      .closed
      .pipe(first())
      .subscribe((userContact: UserContact): void => {
        if (userContact) {
          this.transactionFormData.patchValue({accountNumber: userContact.accountNumber});
        }
      });
  }
}
