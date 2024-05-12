import { ChartDataSet } from './chart-data-set';

export class ChartConfig {
  constructor(
    public type: string,
    public data: {
      labels: string[]
      datasets: ChartDataSet[]
    }) {}
}