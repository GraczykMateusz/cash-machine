import { Component } from '@angular/core';
import { TransactionsTableComponent } from './ui/transactions-table/transactions-table.component';

@Component({
    selector: 'app-history',
    imports: [
        TransactionsTableComponent
    ],
    templateUrl: './history.component.html',
    styleUrl: './history.component.scss'
})
export class HistoryComponent {

}
