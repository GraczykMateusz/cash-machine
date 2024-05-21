package dev.graczykmateusz.cashmachine.account.contact;

import java.util.ArrayList;
import java.util.List;

class UserContactRepositoryInMemory implements UserContactRepository {

  private final List<UserContact> data = new ArrayList<>();

  @Override
  public <S extends UserContact> S save(S entity) {
    data.add(entity);
    return entity;
  }

  @Override
  public void deleteById(String id) {
    data.removeIf(e -> e.getId().equals(id));
  }

  @Override
  public void deleteAll() {
    data.clear();
  }
}
