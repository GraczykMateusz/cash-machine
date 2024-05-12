package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;
import java.util.List;

interface CurrencyDetailsQueryRepository {

  List<CurrencyDetails> findAll();
  
  List<CurrencyDetails> findByExchangeSymbol(ExchangeSymbol exchangeSymbol);
}
