package dev.graczykmateusz.cashmachine.forex.client;

import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyDetailsForexResponseDto;
import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;
import reactor.core.publisher.Mono;

public interface CurrencyForexClient {

  Mono<CurrencyDetailsForexResponseDto> retrieveCurrentCurrencyDetails(
      ExchangeSymbol exchangeSymbol);

  Mono<CurrencyDetailsForexResponseDto> retrieveDailyCurrencyDetails(ExchangeSymbol exchangeSymbol);
}
