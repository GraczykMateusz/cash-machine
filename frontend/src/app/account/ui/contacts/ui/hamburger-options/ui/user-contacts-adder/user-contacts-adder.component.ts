import { Component, inject } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { accountNumberValidator } from '../../../../../../../common/account-number/validator/account-number-validator';
import { AccountNumberService } from '../../../../../../../common/account-number/account-number.service';
import { userContactNameValidator } from '../../../../../../../common/user-contact-name/validator/user-contact-name-validator';

@Component({
  selector: 'app-user-contacts-adder',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './user-contacts-adder.component.html',
  styleUrl: './user-contacts-adder.component.scss'
})
export class UserContactsAdderComponent {
  
  private readonly _userAccount: AccountNumberService = inject(AccountNumberService);
  
  readonly accountGroup: FormGroup = new FormGroup({
    accountNumber: new FormControl('', accountNumberValidator()),
    contactName: new FormControl('', userContactNameValidator())
  });
  
  formatAccountNumber(event: Event): void {
    const input: HTMLInputElement = event.target as HTMLInputElement;
    const formattedInput: string = this._userAccount.formatAccountNumber(input.value);
    this.accountGroup.controls['accountNumber'].setValue(formattedInput, {emitEvent: false});
  }
  
  addNewContact(): void {
  
  }
}
