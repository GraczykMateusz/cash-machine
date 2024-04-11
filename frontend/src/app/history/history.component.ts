import { Component } from '@angular/core';
import { TransactionCardComponent } from './ui/transaction-card/transaction-card.component';

@Component({
  selector: 'app-history',
  standalone: true,
  imports: [
    TransactionCardComponent
  ],
  templateUrl: './history.component.html',
  styleUrl: './history.component.scss'
})
export class HistoryComponent {

}
