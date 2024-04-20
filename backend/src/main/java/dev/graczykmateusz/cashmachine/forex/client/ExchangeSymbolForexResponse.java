package dev.graczykmateusz.cashmachine.forex.client;

import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
class ExchangeSymbolForexResponse {

  private String exchangeSymbol;

  ExchangeSymbol toConst() {
    return ExchangeSymbol.valueOf(exchangeSymbol.substring(exchangeSymbolForexPrefixLength()));
  }

  private int exchangeSymbolForexPrefixLength() {
    return "C:".length();
  }
}
