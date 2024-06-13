package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CurrencyDetailsRepositoryInMemory
    implements CurrencyDetailsRepository, CurrencyDetailsQueryRepository {

  private final List<CurrencyDetails> data = new ArrayList<>();

  @Override
  public <S extends CurrencyDetails> S save(S entity) {
    data.add(entity);
    return entity;
  }

  @Override
  public void deleteAll() {
    data.clear();
  }

  @Override
  public List<CurrencyDetails> findAll() {
    return Collections.unmodifiableList(data);
  }

  @Override
  public List<CurrencyDetails> findByExchangeSymbol(ExchangeSymbol exchangeSymbol) {
    return data.stream()
        .filter(currencyDetails -> currencyDetails.getExchangeSymbol().equals(exchangeSymbol))
        .toList();
  }
}
