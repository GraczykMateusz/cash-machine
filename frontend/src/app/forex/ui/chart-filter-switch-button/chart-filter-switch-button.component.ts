import { Component, input, InputSignal } from '@angular/core';

@Component({
  selector: 'app-chart-filter-switch-button',
  standalone: true,
  imports: [],
  templateUrl: './chart-filter-switch-button.component.html',
  styleUrl: './chart-filter-switch-button.component.scss'
})
export class ChartFilterSwitchButtonComponent {
  
  buttonName: InputSignal<string> = input.required<string>();
}
