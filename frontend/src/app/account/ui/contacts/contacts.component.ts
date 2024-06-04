import { Component, inject, Signal } from '@angular/core';
import { NgbAccordionBody, NgbAccordionButton, NgbAccordionCollapse, NgbAccordionDirective, NgbAccordionHeader, NgbAccordionItem, NgbAccordionToggle, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { UserContactsService } from './data/user-contacts.service';
import { AllUserContacts } from './data/all-user-contacts';
import { LoadingSpinnerComponent } from '../../../common/loading-spinner/loading-spinner.component';
import { UserContact } from './data/user-contact';

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
    NgbAccordionToggle
  ],
  templateUrl: './contacts.component.html',
  styleUrl: './contacts.component.scss'
})
export class ContactsComponent {
  
  private readonly modal: NgbActiveModal = inject(NgbActiveModal);
  private readonly contactsService: UserContactsService = inject(UserContactsService);
  
  readonly allUserContacts: Signal<AllUserContacts | undefined> = this.contactsService.allUserContacts;
  
  cancel(): void {
    this.modal.close();
  }
  
  select(userContact: UserContact): void {
    this.modal.close(userContact);
  }
}
