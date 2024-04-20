package dev.graczykmateusz.cashmachine.forex.currency.dto;

import dev.graczykmateusz.cashmachine.abstraction.query.Result;
import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;

import java.util.List;

public record CurrencyDetailsDto(ExchangeSymbol exchangeSymbol, List<CurrencyPriceDto> currencyPrices)
    implements Result {}
