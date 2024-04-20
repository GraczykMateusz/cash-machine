package dev.graczykmateusz.cashmachine.forex.currency.dto;

import dev.graczykmateusz.cashmachine.abstraction.query.Result;
import lombok.Value;

import java.util.List;

@Value
public class AllCurrencyDetailsDto implements Result {
    
    List<CurrencyDetailsDto> currencyDetailsDtos;
}
