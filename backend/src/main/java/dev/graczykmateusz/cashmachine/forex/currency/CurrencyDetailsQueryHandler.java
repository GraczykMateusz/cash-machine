package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.abstraction.query.Query;
import dev.graczykmateusz.cashmachine.abstraction.query.QueryHandler;
import dev.graczykmateusz.cashmachine.abstraction.query.Result;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class CurrencyDetailsQueryHandler implements QueryHandler<Result, Query> {

  private final CurrencyDetailsQueryRepository queryRepository;

  @Override
  public Result handle(Query query) {
    List<CurrencyDetails> all = queryRepository.findAll();
    return null;
  }
}
