import { Component } from '@angular/core';
import { CurrencyPipe, DecimalPipe } from '@angular/common';

@Component({
  selector: 'app-card',
  imports: [
    DecimalPipe,
    CurrencyPipe
  ],
  templateUrl: './card.component.html',
  styleUrl: './card.component.scss'
})
export class CardComponent {

  accountType: string = 'PLATINUM';
  accountNumber: string = '0123 4567 8901 2345';
  balance: number = 900000.28;
  currency: string = 'PLN';
}
