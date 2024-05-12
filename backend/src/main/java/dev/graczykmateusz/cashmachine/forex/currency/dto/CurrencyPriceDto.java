package dev.graczykmateusz.cashmachine.forex.currency.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CurrencyPriceDto(
    BigDecimal closePrice,
    BigDecimal highestPrice,
    BigDecimal lowestPrice,
    BigDecimal numberOfTransactions,
    BigDecimal openPrice,
    LocalDateTime timestamp,
    BigDecimal tradingVolume,
    BigDecimal volumeWeightedAveragePrice) {}
