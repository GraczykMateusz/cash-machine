import { Component, computed, inject, input, InputSignal, Signal } from '@angular/core';
import { ChartFilterType } from '../../data/chart/chart-filter-type';
import { ChartService } from '../../data/chart/chart.service';
import { NgStyle } from '@angular/common';

@Component({
    selector: 'app-chart-filter-switch-button',
    imports: [
        NgStyle
    ],
    templateUrl: './chart-filter-switch-button.component.html',
    styleUrl: './chart-filter-switch-button.component.scss'
})
export class ChartFilterSwitchButtonComponent {
  
  private readonly chartService: ChartService = inject(ChartService);
  readonly chartFilter: Signal<ChartFilterType> = computed(() => this.chartService.chartFilter());
  
  readonly buttonName: InputSignal<string> = input.required<string>();
  readonly filterType: InputSignal<ChartFilterType> = input.required<ChartFilterType>();
  
  updateFilter(): void {
    if (this.chartFilter() == this.filterType()) {
      return;
    }
    this.chartService.updateChartFilter(this.filterType());
  }
}
