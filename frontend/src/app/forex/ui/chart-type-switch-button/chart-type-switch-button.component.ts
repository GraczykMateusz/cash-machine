import { Component, computed, inject, Signal } from '@angular/core';
import { ChartType } from './data/chart-type';
import { ChartService } from '../../data/chart/chart.service';

@Component({
  selector: 'app-chart-type-switch-button',
  standalone: true,
  imports: [],
  templateUrl: './chart-type-switch-button.component.html',
  styleUrl: './chart-type-switch-button.component.scss'
})
export class ChartTypeSwitchButtonComponent {
  
  private readonly chartService: ChartService = inject(ChartService);
  readonly chartType: Signal<ChartType> = computed(() => this.chartService.chartType());
  
  changeChartType(): void {
    this.chartService.updateChartType((this.chartType() == 'EURPLN' ? 'USDPLN' : 'EURPLN'));
  };
}
