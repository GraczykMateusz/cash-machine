package dev.graczykmateusz.cashmachine.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class AccountRepositoryInMemory implements AccountRepository, AccountQueryRepository {

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

  @Override
  public Optional<Account> findById(String id) {
    return data.stream().filter(account -> account.getId().equals(id)).findFirst();
  }

  @Override
  public Optional<Account> findByPersonalId(String personalId) {
    return data.stream().filter(account -> account.getPersonalId().equals(personalId)).findFirst();
  }
}
