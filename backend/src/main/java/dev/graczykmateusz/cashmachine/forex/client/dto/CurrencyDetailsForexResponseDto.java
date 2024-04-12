package dev.graczykmateusz.cashmachine.forex.client.dto;

import java.util.List;

public record CurrencyDetailsForexResponseDto(
    String exchangeSymbol, List<CurrencyPriceForexResponseDto> currencyPrices) {}
