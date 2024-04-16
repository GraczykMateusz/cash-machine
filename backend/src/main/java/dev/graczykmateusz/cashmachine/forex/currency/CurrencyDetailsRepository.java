package dev.graczykmateusz.cashmachine.forex.currency;

interface CurrencyDetailsRepository {

  <S extends CurrencyDetails> S save(S entity);
}
