package dev.graczykmateusz.cashmachine.forex.currency.query;

import dev.graczykmateusz.cashmachine.abstraction.query.Query;
import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class GetCurrencyDetails implements Query {
  @NotNull ExchangeSymbol exchangeSymbol;
}
