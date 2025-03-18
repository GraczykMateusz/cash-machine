import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export function accountNumberValidator(): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const isValid = isAccountValid(control);
    return isValid ? null : {error: 'Account number must be in the format: XXXX XXXX XXXX XXXX.'};
  };
}

function isAccountValid(control: AbstractControl) {
  const accountNumber = control.value;
  return accountNumber && /^(\d{4} ){3}\d{4}$/.test(accountNumber);
}
