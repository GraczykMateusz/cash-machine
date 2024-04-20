package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyPriceForexResponseDto;
import dev.graczykmateusz.cashmachine.forex.currency.dto.CurrencyPriceDto;
import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter(AccessLevel.PROTECTED)
class CurrencyPrice {

  private BigDecimal closePrice;
  private BigDecimal highestPrice;
  private BigDecimal lowestPrice;
  private BigDecimal numberOfTransactions;
  private BigDecimal openPrice;
  private BigDecimal timestamp;
  private BigDecimal tradingVolume;
  private BigDecimal volumeWeightedAveragePrice;

  CurrencyPriceDto toDto() {
    return new CurrencyPriceDto(
        closePrice,
        highestPrice,
        lowestPrice,
        numberOfTransactions,
        openPrice,
        timestamp,
        tradingVolume,
        volumeWeightedAveragePrice);
  }

  static CurrencyPrice toDomain(CurrencyPriceForexResponseDto currencyPriceForexResponse) {
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
