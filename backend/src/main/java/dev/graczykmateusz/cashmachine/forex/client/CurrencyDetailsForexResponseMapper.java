package dev.graczykmateusz.cashmachine.forex.client;

import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyDetailsForexResponseDto;
import dev.graczykmateusz.cashmachine.forex.client.exception.EmptyCurrencyPriceListException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class CurrencyDetailsForexResponseMapper {

  static CurrencyDetailsForexResponseDto toDto(
      CurrencyDetailsForexResponse currencyDetailsForexResponse) {

    var currencyPrices = currencyDetailsForexResponse.getCurrencyPrice();

    if (currencyPrices == null || currencyPrices.isEmpty()) {
      throw new EmptyCurrencyPriceListException();
    }
    
    var currencyPriceForexResponses =
        currencyPrices.stream().map(CurrencyPriceForexResponseMapper::toDto).toList();

    return new CurrencyDetailsForexResponseDto(
        currencyDetailsForexResponse.getExchangeSymbol().toConst(), currencyPriceForexResponses);
  }
}
