import { Component } from '@angular/core';
import { CardComponent } from './ui/card/card.component';
import { TransactionFormComponent } from './ui/transaction-form/transaction-form.component';

@Component({
  selector: 'app-account',
  standalone: true,
  imports: [
    CardComponent,
    TransactionFormComponent
  ],
  templateUrl: './account.component.html',
  styleUrl: './account.component.scss'
})
export class AccountComponent {

}
