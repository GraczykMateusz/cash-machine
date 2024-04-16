package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyPriceForexResponseDto;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class CurrencyPrice {

  private BigDecimal closePrice;
  private BigDecimal highestPrice;
  private BigDecimal lowestPrice;
  private BigDecimal numberOfTransactions;
  private BigDecimal openPrice;
  private BigDecimal timestamp;
  private BigDecimal tradingVolume;
  private BigDecimal volumeWeightedAveragePrice;

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
