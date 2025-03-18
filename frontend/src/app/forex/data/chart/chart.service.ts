import { computed, Injectable, signal, WritableSignal } from '@angular/core';
import { ChartType } from '../../ui/chart-type-switch-button/data/chart-type';
import Chart from 'chart.js/auto';
import { ChartFilterType } from './chart-filter-type';
import { CurrencyPrice } from '../detail/currency-price';

@Injectable({
  providedIn: 'root'
})
export class ChartService {

  private static readonly CHART_ID: string = 'chart';

  private readonly _chartType: WritableSignal<ChartType> = signal('EURPLN');
  private readonly _chartFilter: WritableSignal<ChartFilterType> = signal('LAST_10M');

  get chartType() {
    return computed(() => this._chartType());
  }

  get chartFilter() {
    return computed(() => this._chartFilter());
  }

  updateChartType(chartType: ChartType): void {
    this._chartType.set(chartType);
  }

  updateChartFilter(chartFilterType: ChartFilterType): void {
    this._chartFilter.set(chartFilterType);
  }

  createChart(currencyPrices: CurrencyPrice[] | undefined): Chart | undefined {
    if (currencyPrices == undefined || currencyPrices.length == 0) {
      return undefined;
    }

    Chart.getChart(ChartService.CHART_ID)?.destroy();

    return new Chart(ChartService.CHART_ID, {
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
