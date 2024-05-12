import { ChartType } from '../../forex/ui/chart-type-switch-button/data/chart-type';

export class ApiBuilder {
  
  private constructor(private url: string) {
  }
  
  static get api() {
    return new ApiBuilder('api');
  }
  
  get v1() {
    return this.append('v1');
  }
  
  get forex() {
    return this.append('forex');
  }
  
  get currencyDetails() {
    return this.append('currency-details');
  }
  
  chartType(chartType: ChartType) {
    return this.append(chartType);
  }
  
  build(): string {
    return this.url;
  }
  
  private append(value: string) {
    this.url += `/${value}`;
    return this;
  }
}
