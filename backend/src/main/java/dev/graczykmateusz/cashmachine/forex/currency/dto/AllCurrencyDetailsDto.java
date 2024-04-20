package dev.graczykmateusz.cashmachine.forex.currency.dto;

import dev.graczykmateusz.cashmachine.abstraction.query.Result;
import java.util.List;

public record AllCurrencyDetailsDto(List<CurrencyDetailsDto> currencyDetails)
    implements Result {}
