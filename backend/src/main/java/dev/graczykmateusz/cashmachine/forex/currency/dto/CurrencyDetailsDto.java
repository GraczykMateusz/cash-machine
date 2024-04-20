package dev.graczykmateusz.cashmachine.forex.currency.dto;

import dev.graczykmateusz.cashmachine.abstraction.query.Result;
import java.util.List;

public record CurrencyDetailsDto(String exchangeSymbol, List<CurrencyPriceDto> currencyPrices)
    implements Result {}
