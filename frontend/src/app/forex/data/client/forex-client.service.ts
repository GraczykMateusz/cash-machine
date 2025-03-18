import { computed, effect, inject, Injectable, signal, Signal, WritableSignal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CurrencyDetails } from '../detail/currency-details';
import { ChartService } from '../chart/chart.service';
import { first } from 'rxjs';
import { ApiBuilder } from '../../../shared/api-builder/api.builder';
import { ChartType } from '../../ui/chart-type-switch-button/data/chart-type';

@Injectable({
  providedIn: 'root'
})
export class ForexClientService {

  private readonly http: HttpClient = inject(HttpClient);
  private readonly chartService: ChartService = inject(ChartService);

  private readonly _currencyDetails: WritableSignal<CurrencyDetails | undefined> = signal(undefined);

  get currencyDetails(): Signal<CurrencyDetails | undefined> {
    return computed(() => this._currencyDetails());
  }

  constructor() {
    effect((): void => {
      this.refreshCurrencyDetails();
    });
  }

  refreshCurrencyDetails(): void {
    const chartType: ChartType = this.chartService.chartType();
    const url: string = ApiBuilder.api.v1.forex.currencyDetails.chartType(chartType).build();
    this.http.get<CurrencyDetails>(url)
    .pipe(first())
    .subscribe((value: CurrencyDetails) => this._currencyDetails.set(value));
  }
}

