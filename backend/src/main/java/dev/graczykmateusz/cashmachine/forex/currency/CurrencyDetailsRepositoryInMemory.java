package dev.graczykmateusz.cashmachine.forex.currency;

import java.util.ArrayList;
import java.util.List;

class CurrencyDetailsRepositoryInMemory implements CurrencyDetailsRepository {

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
}
