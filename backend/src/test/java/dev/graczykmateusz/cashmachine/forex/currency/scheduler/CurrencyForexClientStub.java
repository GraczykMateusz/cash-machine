package dev.graczykmateusz.cashmachine.forex.currency.scheduler;

import dev.graczykmateusz.cashmachine.forex.client.CurrencyForexClient;
import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyDetailsForexResponseDto;
import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyPriceForexResponseDto;
import java.math.BigDecimal;
import java.util.List;

class CurrencyForexClientStub implements CurrencyForexClient {
  
  @Override
  public CurrencyDetailsForexResponseDto retrieveCurrencyDetails() {
    var currencyPriceForexResponseDto =
        new CurrencyPriceForexResponseDto(
            BigDecimal.valueOf(0),
            BigDecimal.valueOf(1),
            BigDecimal.valueOf(2),
            BigDecimal.valueOf(3),
            BigDecimal.valueOf(4),
            BigDecimal.valueOf(5),
            BigDecimal.valueOf(6),
            BigDecimal.valueOf(7));
    return new CurrencyDetailsForexResponseDto(
        "exchangeSymbol", List.of(currencyPriceForexResponseDto));
  }
}
