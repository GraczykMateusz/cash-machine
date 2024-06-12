package dev.graczykmateusz.cashmachine.account;

import java.util.ArrayList;
import java.util.List;

class AccountRepositoryInMemory implements AccountRepository {

  private final List<Account> data = new ArrayList<>();

  @Override
  public <S extends Account> S save(S entity) {
    data.add(entity);
    return entity;
  }

  @Override
  public void deleteAll() {
    data.clear();
  }
}
