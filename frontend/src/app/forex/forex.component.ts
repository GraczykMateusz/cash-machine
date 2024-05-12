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
  
  private readonly _currencyDetails: Signal<CurrencyDetails | undefined> = this.forexClientService.currencyDetails;
  
  protected readonly chartType: Signal<ChartType> = this.chartService.chartType;
  
  protected readonly currencyChart = computed(() => {
    if (this._currencyDetails()?.currencyPrices) {
      let chartStatus = Chart.getChart('chart');
      if (chartStatus != undefined) {
        chartStatus.destroy();
      }
      return this.chartService.create(this._currencyDetails()!.currencyPrices);
    } else {
      return undefined;
    }
  })
  
  get currencyDetails(): Signal<CurrencyDetails | undefined> {
    return computed(() => this._currencyDetails());
  }
}
