import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AccountNumberService {
  
  formatAccountNumber(input: string): string {
    let value: string = this.removeAllSpaces(input);
    value = this.trimToMaxSixteenDigitsIfNeeded(value);
    return this.addSpaceEveryFourDigits(value);
  }
  
  private addSpaceEveryFourDigits(value: string): string {
    return value.match(/.{1,4}/g)?.join(' ') ?? '';
  }
  
  private trimToMaxSixteenDigitsIfNeeded(value: string): string {
    if (value.length > 16) {
      value = value.slice(0, 16);
    }
    return value;
  }
  
  private removeAllSpaces(value: string): string {
    return value.replace(/\s+/g, '');
  }
}
