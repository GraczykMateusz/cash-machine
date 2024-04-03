import { Component } from '@angular/core';

@Component({
  selector: 'app-account',
  standalone: true,
  imports: [],
  templateUrl: './account.component.html',
  styleUrl: './account.component.scss'
})
export class AccountComponent {
  
  accountType: string = 'PLATINUM';
  accountNumber: string = '0123 4567 8901 2345';
  balance: number = 100;
  currency: string = 'PLN';
}
