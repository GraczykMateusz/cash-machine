package dev.graczykmateusz.cashmachine.forex.currency.scheduler;

import dev.graczykmateusz.cashmachine.forex.client.CurrencyForexClient;
import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyDetailsForexResponseDto;
import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyPriceForexResponseDto;
import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;
import java.util.List;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
class CurrencyForexClientStub implements CurrencyForexClient {

  private final String exchangeSymbol;
  private final List<CurrencyPriceForexResponseDto> currencyPrices;

  @Override
  public Mono<CurrencyDetailsForexResponseDto> retrieveCurrencyDetails(
      ExchangeSymbol exchangeSymbol) {
    return Mono.just(new CurrencyDetailsForexResponseDto(this.exchangeSymbol, currencyPrices));
  }

  @Override
  public Mono<CurrencyDetailsForexResponseDto> retrieveHistoricalDetails(
      ExchangeSymbol exchangeSymbol) {
    return Mono.just(new CurrencyDetailsForexResponseDto(this.exchangeSymbol, currencyPrices));
  }
}
