package dev.graczykmateusz.cashmachine.forex.currency.dto;

import java.math.BigDecimal;

public record CurrencyPriceDto(
    BigDecimal closePrice,
    BigDecimal highestPrice,
    BigDecimal lowestPrice,
    BigDecimal numberOfTransactions,
    BigDecimal openPrice,
    BigDecimal timestamp,
    BigDecimal tradingVolume,
    BigDecimal volumeWeightedAveragePrice) {}
