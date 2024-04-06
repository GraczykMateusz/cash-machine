import { Component } from '@angular/core';

@Component({
  selector: 'app-card',
  standalone: true,
  imports: [],
  templateUrl: './card.component.html',
  styleUrl: './card.component.scss'
})
export class CardComponent {
  
  accountType: string = 'PLATINUM';
  accountNumber: string = '0123 4567 8901 2345';
  balance: string = '1000000000';
  currency: string = 'PLN';
}
