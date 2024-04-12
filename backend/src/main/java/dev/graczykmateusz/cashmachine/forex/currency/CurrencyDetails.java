package dev.graczykmateusz.cashmachine.forex.currency;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
class CurrencyDetails {
  
  @Id
  private String id;
  private String exchangeSymbol;
  private List<CurrencyPrice> currencyPrices;
  
  CurrencyDetails(String exchangeSymbol, List<CurrencyPrice> currencyPrices) {
    this.exchangeSymbol = exchangeSymbol;
    this.currencyPrices = currencyPrices;
  }
}
