package dev.graczykmateusz.cashmachine.forex.client;

import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyPriceForexResponseDto;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class CurrencyPriceForexResponseMapper {

  static CurrencyPriceForexResponseDto toDto(
      CurrencyPriceForexResponse currencyPriceForexResponse) {
    return new CurrencyPriceForexResponseDto(
        currencyPriceForexResponse.getClosePrice(),
        currencyPriceForexResponse.getHighestPrice(),
        currencyPriceForexResponse.getLowestPrice(),
        currencyPriceForexResponse.getNumberOfTransactions(),
        currencyPriceForexResponse.getOpenPrice(),
        currencyPriceForexResponse.getTimestamp(),
        currencyPriceForexResponse.getTradingVolume(),
        currencyPriceForexResponse.getVolumeWeightedAveragePrice());
  }
}
