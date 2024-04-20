import { Component, inject, Signal } from '@angular/core';
import { ChartConfiguration, ChartOptions } from 'chart.js';
import { BaseChartDirective } from 'ng2-charts';
import { ForexClientService } from './data/client/forex-client.service';
import { LoadingSpinnerComponent } from '../common/loading-spinner/loading-spinner.component';
import { CurrencyDetailsList } from './data/currency-details-list';

@Component({
  selector: 'app-forex',
  standalone: true,
  imports: [
    BaseChartDirective,
    LoadingSpinnerComponent
  ],
  templateUrl: './forex.component.html',
  styleUrl: './forex.component.scss'
})
export class ForexComponent {
  
  private readonly forexClientService: ForexClientService = inject(ForexClientService);
  protected readonly currencyDetails: Signal<CurrencyDetailsList | null> = this.forexClientService.currencyDetails;
  
  public lineChartOptions: ChartOptions<'line'> = {
    responsive: true,
    maintainAspectRatio: false
  };
  public lineChartLegend = true;
  
  
  test(x: CurrencyDetailsList): ChartConfiguration<'line'>['data'] {
    return {
      labels: x.currencyDetails[0].currencyPrices.map(value => value.timestamp),
      datasets: [
        {
          data:  x.currencyDetails[0].currencyPrices.map(value => value.volumeWeightedAveragePrice),
          label: x.currencyDetails[0].exchangeSymbol,
          fill: true,
          tension: 0.5,
          borderColor: 'black',
          backgroundColor: 'rgba(255,0,0,0.3)'
        }
      ]
    };
  }
}
