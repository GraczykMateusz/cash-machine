import { computed, inject, Injectable, Signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { toSignal } from '@angular/core/rxjs-interop';
import { CurrencyDetailsList } from '../currency-details-list';

@Injectable({
  providedIn: 'root'
})
export class ForexClientService {
  
  private readonly http: HttpClient = inject(HttpClient);
  
  private _currencyDetails: Signal<CurrencyDetailsList | null> = toSignal(this.http.get<CurrencyDetailsList>('/api/v1/forex/currency-details/all'), {initialValue: null});
  
  get currencyDetails(): Signal<CurrencyDetailsList | null> {
    return computed(() => this._currencyDetails());
  }
}
