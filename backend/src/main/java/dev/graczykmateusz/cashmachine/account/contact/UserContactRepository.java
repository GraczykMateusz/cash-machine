package dev.graczykmateusz.cashmachine.account.contact;

interface UserContactRepository {

  <S extends UserContact> S save(S entity);

  void deleteById(String id);

  void deleteAll();
}
