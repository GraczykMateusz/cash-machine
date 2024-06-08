import { computed, Injectable, Signal, signal, WritableSignal } from '@angular/core';
import { AllUserContacts } from '../../../../../data/all-user-contacts';
import { UserContact } from '../../../../../data/user-contact';

@Injectable({
  providedIn: 'root'
})
export class UsersFilterService {
  
  private readonly _filterValue: WritableSignal<string> = signal<string>('');
  
  get filterValue(): Signal<string> {
    return computed(() => this._filterValue());
  }
  
  setValue(filterValue: string): void {
    this._filterValue.set(filterValue.toLowerCase());
  }
  
  clearValue(): void {
    this._filterValue.set('');
  }
  
  filter(contacts: AllUserContacts | undefined): UserContact[] {
    if (contacts?.contacts == undefined) {
      return []
    }
    return contacts.contacts
      .filter((contact: UserContact) => {
        const foundAssignedName: boolean = contact.assignedName.toLowerCase().startsWith(this._filterValue());
        const foundAccountNumber: boolean = contact.accountNumber.toLowerCase().startsWith(this._filterValue());
        return foundAssignedName || foundAccountNumber;
      });
  }
}
