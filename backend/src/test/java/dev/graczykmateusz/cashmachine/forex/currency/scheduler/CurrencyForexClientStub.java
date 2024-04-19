package dev.graczykmateusz.cashmachine.forex.currency.scheduler;

import dev.graczykmateusz.cashmachine.forex.client.CurrencyForexClient;
import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyDetailsForexResponseDto;
import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyPriceForexResponseDto;
import dev.graczykmateusz.cashmachine.forex.constants.AvailableCurrencyPair;
import java.math.BigDecimal;
import java.util.List;
import reactor.core.publisher.Mono;

class CurrencyForexClientStub implements CurrencyForexClient {

  @Override
  public Mono<CurrencyDetailsForexResponseDto> retrieveCurrencyDetails(
      AvailableCurrencyPair availableCurrencyPair) {
    
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
    
    return Mono.just(
        new CurrencyDetailsForexResponseDto(
            "exchangeSymbol", List.of(currencyPriceForexResponseDto)));
  }
}
