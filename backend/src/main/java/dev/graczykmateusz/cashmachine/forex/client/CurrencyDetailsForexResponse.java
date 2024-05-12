package dev.graczykmateusz.cashmachine.forex.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
class CurrencyDetailsForexResponse {

  @JsonProperty("ticker")
  private ExchangeSymbolForexResponse exchangeSymbol;

  @JsonProperty("results")
  private List<CurrencyPriceForexResponse> currencyPrice;
}
