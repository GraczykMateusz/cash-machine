package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyPriceForexResponseDto;
import dev.graczykmateusz.cashmachine.forex.currency.dto.CurrencyPriceDto;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class CurrencyPriceMapper {

  static CurrencyPriceDto toDto(CurrencyPrice currencyPrice) {
    return new CurrencyPriceDto(
        currencyPrice.getClosePrice(),
        currencyPrice.getHighestPrice(),
        currencyPrice.getLowestPrice(),
        currencyPrice.getNumberOfTransactions(),
        currencyPrice.getOpenPrice(),
        LocalDateTime.ofInstant(
            Instant.ofEpochMilli(currencyPrice.getTimestamp().longValue()), ZoneId.systemDefault()),
        currencyPrice.getTradingVolume(),
        currencyPrice.getVolumeWeightedAveragePrice());
  }

  static CurrencyPrice fromDto(CurrencyPriceForexResponseDto currencyPriceForexResponse) {
    return new CurrencyPrice(
        currencyPriceForexResponse.closePrice(),
        currencyPriceForexResponse.highestPrice(),
        currencyPriceForexResponse.lowestPrice(),
        currencyPriceForexResponse.numberOfTransactions(),
        currencyPriceForexResponse.openPrice(),
        currencyPriceForexResponse.timestamp(),
        currencyPriceForexResponse.tradingVolume(),
        currencyPriceForexResponse.volumeWeightedAveragePrice());
  }
}
