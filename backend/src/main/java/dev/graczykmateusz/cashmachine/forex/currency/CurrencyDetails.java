package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "currency-details")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter(AccessLevel.PROTECTED)
class CurrencyDetails {

  @Id private String id;
  private ExchangeSymbol exchangeSymbol;
  private List<CurrencyPrice> currencyPrices;

  CurrencyDetails(ExchangeSymbol exchangeSymbol, List<CurrencyPrice> currencyPrices) {
    this.exchangeSymbol = exchangeSymbol;
    this.currencyPrices = currencyPrices;
  }
}
