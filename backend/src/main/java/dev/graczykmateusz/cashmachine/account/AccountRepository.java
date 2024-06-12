package dev.graczykmateusz.cashmachine.account;

interface AccountRepository {

  <S extends Account> S save(S entity);
  
  void deleteAll();
}
