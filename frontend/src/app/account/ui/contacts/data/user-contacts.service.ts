import { computed, inject, Injectable, Signal, signal, WritableSignal } from '@angular/core';
import { ApiBuilder } from '../../../../shared/api-builder/api.builder';
import { first } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { AllUserContacts } from './all-user-contacts';

@Injectable({
  providedIn: 'root'
})
export class UserContactsService {

  accountId = '123'; // todo

  private readonly http: HttpClient = inject(HttpClient);
  private readonly _allUserContacts: WritableSignal<AllUserContacts | undefined> = signal(undefined);
  
  constructor() {
    const url: string = ApiBuilder.api.v1.account(this.accountId).contacts.build();
    this.http.get<AllUserContacts>(url)
      .pipe(first())
      .subscribe((value: AllUserContacts) => this._allUserContacts.set(value));
  }
  
  get allUserContacts(): Signal<AllUserContacts | undefined> {
    return computed(() => this._allUserContacts());
  }
}
