import { Component } from '@angular/core';
import { NgbDateStruct, NgbInputDatepicker } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-transaction-form',
  standalone: true,
  imports: [
    NgbInputDatepicker,
    FormsModule
  ],
  templateUrl: './transaction-form.component.html',
  styleUrl: './transaction-form.component.scss'
})
export class TransactionFormComponent {
  
  model?: NgbDateStruct;
  
}
