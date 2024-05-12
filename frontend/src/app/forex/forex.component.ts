import { Component, computed, inject, Signal } from '@angular/core';
import { BaseChartDirective } from 'ng2-charts';
import { ForexClientService } from './data/client/forex-client.service';
import { LoadingSpinnerComponent } from '../common/loading-spinner/loading-spinner.component';
import { CurrencyDetails } from './data/detail/currency-details';
import { NgClass, NgOptimizedImage } from '@angular/common';
import { NgbDropdown, NgbDropdownItem, NgbDropdownMenu, NgbDropdownToggle } from '@ng-bootstrap/ng-bootstrap';
import { ChartTypeSwitchButtonComponent } from './ui/chart-type-switch-button/chart-type-switch-button.component';
import { ChartFilterSwitchButtonComponent } from './ui/chart-filter-switch-button/chart-filter-switch-button.component';
import { ChartService } from './data/chart/chart.service';
import Chart from 'chart.js/auto';
import { ChartType } from './ui/chart-type-switch-button/data/chart-type';

@Component({
  selector: 'app-forex',
  standalone: true,
  imports: [
    BaseChartDirective,
    LoadingSpinnerComponent,
    NgOptimizedImage,
    NgbDropdown,
    NgbDropdownItem,
    NgbDropdownMenu,
    NgbDropdownToggle,
    ChartTypeSwitchButtonComponent,
    ChartFilterSwitchButtonComponent,
    NgClass
  ],
  templateUrl: './forex.component.html',
  styleUrl: './forex.component.scss'
})
export class ForexComponent {
  
  private readonly forexClientService: ForexClientService = inject(ForexClientService);
  private readonly chartService: ChartService = inject(ChartService);
  
  readonly currencyDetails: Signal<CurrencyDetails | undefined> =
    computed(() => this.forexClientService.currencyDetails());
  readonly chartType: Signal<ChartType> =
    computed(() => this.chartService.chartType());
  readonly currencyChart: Signal<Chart<any> | undefined> =
    computed(() => this.chartService.createChart(this.currencyDetails()?.currencyPrices));
}
