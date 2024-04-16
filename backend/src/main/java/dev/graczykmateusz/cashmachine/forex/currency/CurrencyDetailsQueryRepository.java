package dev.graczykmateusz.cashmachine.forex.currency;

import java.util.List;

interface CurrencyDetailsQueryRepository {
  
  List<CurrencyDetails> findAll();
}
