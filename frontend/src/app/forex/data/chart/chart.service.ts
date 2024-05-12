import { computed, Injectable, signal, WritableSignal } from '@angular/core';
import { CurrencyPrice } from '../detail/currency-price';
import { ChartType } from '../../ui/chart-type-switch-button/data/chart-type';
import Chart from 'chart.js/auto';

@Injectable({
  providedIn: 'root'
})
export class ChartService {
  
  private readonly _chartType: WritableSignal<ChartType> = signal('EURPLN');
  
  public get chartType() {
    return computed(() => this._chartType());
  }
  
  public updateChartType(chartType: ChartType): void {
    this._chartType.set(chartType);
  }
  
  public create(currencyPrices: CurrencyPrice[]): Chart {
    return new Chart('chart', {
      type: 'line',
      data: {
        labels: currencyPrices.map(v => {
          return v.timestamp.substring(v.timestamp.indexOf('T') + 'T'.length, v.timestamp.lastIndexOf(':'));
        }).filter((value, index) => index % 10 == 0),
        datasets: [
          {
            label: 'Average',
            data: currencyPrices.map(v => v.volumeWeightedAveragePrice).filter((value, index) => index % 10 == 0),
            pointStyle: false,
            borderColor: '#6ec842',
            backgroundColor: '#6ec842'
          },
          {
            label: 'Highest',
            data: currencyPrices.map(v => v.highestPrice).filter((value, index) => index % 10 == 0),
            pointStyle: false,
            borderColor: '#4261c8',
            backgroundColor: '#4261c8',
            hidden: true
          },
          {
            label: 'Lowest',
            data: currencyPrices.map(v => v.lowestPrice).filter((value, index) => index % 10 == 0),
            pointStyle: false,
            borderColor: '#6f42c8',
            backgroundColor: '#6f42c8',
            hidden: true
          },
          {
            label: 'Close',
            data: currencyPrices.map(v => v.closePrice).filter((value, index) => index % 10 == 0),
            pointStyle: false,
            borderColor: '#42c8a4',
            backgroundColor: '#42c8a4',
            hidden: true
          },
          {
            label: 'Open',
            data: currencyPrices.map(v => v.openPrice).filter((value, index) => index % 10 == 0),
            pointStyle: false,
            borderColor: '#bb42c8',
            backgroundColor: '#bb42c8',
            hidden: true
          },
          {
            label: 'Trading Volume',
            data: currencyPrices.map(v => v.tradingVolume).filter((value, index) => index % 10 == 0),
            pointStyle: false,
            borderColor: '#c8425b',
            backgroundColor: '#c8425b',
            hidden: true
          }
        ]
      },
      options: {
        responsive: true,
        maintainAspectRatio: false
      }
    });
  }
}
