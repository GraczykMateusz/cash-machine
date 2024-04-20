package dev.graczykmateusz.cashmachine.forex.currency;

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
}
