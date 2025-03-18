import { Component, computed, inject, Signal } from '@angular/core';
import { NgbAccordionBody, NgbAccordionButton, NgbAccordionCollapse, NgbAccordionDirective, NgbAccordionHeader, NgbAccordionItem, NgbAccordionToggle, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { UserContactsService } from './data/user-contacts.service';
import { AllUserContacts } from './data/all-user-contacts';
import { LoadingSpinnerComponent } from '../../../common/loading-spinner/loading-spinner.component';
import { UserContact } from './data/user-contact';
import { HamburgerComponent } from '../../../common/hamburger/hamburger.component';
import { HamburgerOptionsComponent } from './ui/hamburger-options/hamburger-options.component';
import { UsersFilterService } from './ui/hamburger-options/ui/user-contacts-filter/data/users-filter.service';

@Component({
    selector: 'app-contacts',
    imports: [
        LoadingSpinnerComponent,
        NgbAccordionDirective,
        NgbAccordionItem,
        NgbAccordionHeader,
        NgbAccordionButton,
        NgbAccordionCollapse,
        NgbAccordionBody,
        NgbAccordionToggle,
        HamburgerComponent,
        HamburgerOptionsComponent
    ],
    templateUrl: './contacts.component.html',
    styleUrl: './contacts.component.scss'
})
export class ContactsComponent {
  
  private readonly modal: NgbActiveModal = inject(NgbActiveModal);
  private readonly contactsService: UserContactsService = inject(UserContactsService);
  private readonly userFilter: UsersFilterService = inject(UsersFilterService);
  
  readonly allUserContacts: Signal<AllUserContacts | undefined> = this.contactsService.allUserContacts;
  readonly userContacts: Signal<UserContact[] | undefined> = computed(() => {
    return this.userFilter.filter(this.allUserContacts());
  });
  
  cancel(): void {
    this.modal.close();
  }
  
  select(userContact: UserContact): void {
    this.modal.close(userContact);
  }
  
  addNewContact(): void {
  
  }
  
  clearFilter(): void {
    this.userFilter.clearValue();
  }
}
