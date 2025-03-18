import { CurrencyPrice } from './currency-price';

export type CurrencyDetails = {
  exchangeSymbol: string,
  currencyPrices: CurrencyPrice[];
}
