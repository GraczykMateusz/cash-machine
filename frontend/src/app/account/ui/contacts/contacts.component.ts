import { Component, computed, inject, signal, Signal, WritableSignal } from '@angular/core';
import { NgbAccordionBody, NgbAccordionButton, NgbAccordionCollapse, NgbAccordionDirective, NgbAccordionHeader, NgbAccordionItem, NgbAccordionToggle, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { UserContactsService } from './data/user-contacts.service';
import { AllUserContacts } from './data/all-user-contacts';
import { LoadingSpinnerComponent } from '../../../common/loading-spinner/loading-spinner.component';
import { UserContact } from './data/user-contact';
import { HamburgerComponent } from '../../../common/hamburger/hamburger.component';

@Component({
  selector: 'app-contacts',
  standalone: true,
  imports: [
    LoadingSpinnerComponent,
    NgbAccordionDirective,
    NgbAccordionItem,
    NgbAccordionHeader,
    NgbAccordionButton,
    NgbAccordionCollapse,
    NgbAccordionBody,
    NgbAccordionToggle,
    HamburgerComponent
  ],
  templateUrl: './contacts.component.html',
  styleUrl: './contacts.component.scss'
})
export class ContactsComponent {
  
  private readonly modal: NgbActiveModal = inject(NgbActiveModal);
  private readonly contactsService: UserContactsService = inject(UserContactsService);
  
  readonly allUserContacts: Signal<AllUserContacts | undefined> = this.contactsService.allUserContacts;
  readonly userContacts: Signal<UserContact[] | undefined> = computed(() => {
    return this.allUserContacts()?.contacts
      .filter((contact: UserContact) => {
        const foundAssignedName: boolean = contact.assignedName.toLowerCase().startsWith(this.filterValue());
        const foundAccountNumber: boolean = contact.accountNumber.toLowerCase().startsWith(this.filterValue());
        return foundAssignedName || foundAccountNumber;
      });
  });
  readonly filterValue: WritableSignal<string> = signal<string>('');
  
  cancel(): void {
    this.modal.close();
  }
  
  select(userContact: UserContact): void {
    this.modal.close(userContact);
  }
  
  filter(event: Event): void {
    this.filterValue.set((event.target as HTMLInputElement).value.toLowerCase());
  }
  
  clearFilter(): void {
    this.filterValue.set('');
  }
  
  addNewContact() {
  
  }
}
