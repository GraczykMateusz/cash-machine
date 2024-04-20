package dev.graczykmateusz.cashmachine.forex.currency.scheduler;

import dev.graczykmateusz.cashmachine.forex.client.CurrencyForexClient;
import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyDetailsForexResponseDto;
import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyPriceForexResponseDto;
import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import lombok.Getter;
import reactor.core.publisher.Mono;

@Getter
class CurrencyForexClientStub implements CurrencyForexClient {

  private final CurrencyDetailsForexResponseDto response;

  CurrencyForexClientStub(ExchangeSymbol exchangeSymbol) {
    BigDecimal zero = BigDecimal.valueOf(0);
    BigDecimal one = BigDecimal.valueOf(1);
    BigDecimal two = BigDecimal.valueOf(2);
    BigDecimal three = BigDecimal.valueOf(3);
    BigDecimal four = BigDecimal.valueOf(4);
    BigDecimal five = BigDecimal.valueOf(5);
    BigDecimal six = BigDecimal.valueOf(6);
    BigDecimal seven = BigDecimal.valueOf(7);

    List<CurrencyPriceForexResponseDto> currencyPrices =
        List.of(new CurrencyPriceForexResponseDto(zero, one, two, three, four, five, six, seven));

    this.response = new CurrencyDetailsForexResponseDto(exchangeSymbol, currencyPrices);
  }

  @Override
  public Mono<CurrencyDetailsForexResponseDto> retrieveCurrentCurrencyDetails(
      ExchangeSymbol exchangeSymbol) {
    return Mono.just(response);
  }
  
  @Override
  public Mono<CurrencyDetailsForexResponseDto> retrieveDailyCurrencyDetails(ExchangeSymbol exchangeSymbol) {
    return Mono.just(response);
  }
}
