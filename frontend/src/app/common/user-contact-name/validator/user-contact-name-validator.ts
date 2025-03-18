import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export function userContactNameValidator(): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const isValid = isUserContactNameValid(control);
    return isValid ? null : {error: 'Contact name cannot be blank'};
  };
}

function isUserContactNameValid(control: AbstractControl) {
  const userContactName = control.value;
  return userContactName && userContactName.trim().length > 0;
}
