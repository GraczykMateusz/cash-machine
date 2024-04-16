package dev.graczykmateusz.cashmachine.forex.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyPriceForexResponseDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Data
@AllArgsConstructor
class CurrencyPriceForexResponse {

  @JsonProperty("c")
  private BigDecimal closePrice;

  @JsonProperty("h")
  private BigDecimal highestPrice;

  @JsonProperty("l")
  private BigDecimal lowestPrice;

  @JsonProperty("n")
  private BigDecimal numberOfTransactions;

  @JsonProperty("o")
  private BigDecimal openPrice;

  @JsonProperty("t")
  private BigDecimal timestamp;

  @JsonProperty("v")
  private BigDecimal tradingVolume;

  @JsonProperty("vw")
  private BigDecimal volumeWeightedAveragePrice;

  CurrencyPriceForexResponseDto toDto() {
    return new CurrencyPriceForexResponseDto(
        closePrice,
        highestPrice,
        lowestPrice,
        numberOfTransactions,
        openPrice,
        timestamp,
        tradingVolume,
        volumeWeightedAveragePrice);
  }
}
