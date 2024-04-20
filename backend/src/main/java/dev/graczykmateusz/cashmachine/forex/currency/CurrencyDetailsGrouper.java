package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class CurrencyDetailsGrouper {

  Map<ExchangeSymbol, List<CurrencyDetails>> groupByExchangeSymbol(
      List<CurrencyDetails> currencyDetails) {
    
    return currencyDetails.stream()
        .collect(Collectors.groupingBy(CurrencyDetails::getExchangeSymbol));
  }
}
