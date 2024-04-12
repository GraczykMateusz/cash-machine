package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.abstraction.query.Query;
import dev.graczykmateusz.cashmachine.abstraction.query.QueryHandler;
import dev.graczykmateusz.cashmachine.abstraction.query.Result;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class CurrencyDetailsQueryHandler implements QueryHandler<Result, Query> {
    
    private final CurrencyDetailsQueryRepository queryRepository;
    
    @Override
    public Result handle(Query query) {
        return null;
    }
}
