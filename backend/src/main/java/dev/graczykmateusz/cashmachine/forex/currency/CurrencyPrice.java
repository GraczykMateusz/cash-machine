package dev.graczykmateusz.cashmachine.forex.currency;

import static org.springframework.data.mongodb.core.mapping.FieldType.DECIMAL128;

import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter(AccessLevel.PROTECTED)
class CurrencyPrice {

  @Field(targetType = DECIMAL128)
  private BigDecimal closePrice;

  @Field(targetType = DECIMAL128)
  private BigDecimal highestPrice;

  @Field(targetType = DECIMAL128)
  private BigDecimal lowestPrice;

  @Field(targetType = DECIMAL128)
  private BigDecimal numberOfTransactions;

  @Field(targetType = DECIMAL128)
  private BigDecimal openPrice;

  @Field(targetType = DECIMAL128)
  private BigDecimal timestamp;

  @Field(targetType = DECIMAL128)
  private BigDecimal tradingVolume;

  @Field(targetType = DECIMAL128)
  private BigDecimal volumeWeightedAveragePrice;
}
