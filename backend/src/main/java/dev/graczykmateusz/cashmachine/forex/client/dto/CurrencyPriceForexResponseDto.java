package dev.graczykmateusz.cashmachine.forex.client.dto;

import java.math.BigDecimal;

public record CurrencyPriceForexResponseDto(
    BigDecimal closePrice,
    BigDecimal highestPrice,
    BigDecimal lowestPrice,
    BigDecimal numberOfTransactions,
    BigDecimal openPrice,
    BigDecimal timestamp,
    BigDecimal tradingVolume,
    BigDecimal volumeWeightedAveragePrice) {}
