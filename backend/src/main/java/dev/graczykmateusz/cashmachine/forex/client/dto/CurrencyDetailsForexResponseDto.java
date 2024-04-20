package dev.graczykmateusz.cashmachine.forex.client.dto;

import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;

import java.util.List;

public record CurrencyDetailsForexResponseDto(
        ExchangeSymbol exchangeSymbol, List<CurrencyPriceForexResponseDto> currencyPrices) {}
