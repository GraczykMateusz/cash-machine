package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.abstraction.query.Query;
import dev.graczykmateusz.cashmachine.abstraction.query.QueryHandler;
import dev.graczykmateusz.cashmachine.abstraction.query.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@RequiredArgsConstructor
class CurrencyDetailsConfiguration {
  
  private final CurrencyDetailsRepository currencyDetailsRepository;
  private final CurrencyDetailsQueryRepository currencyDetailsQueryRepository;

  @Bean
  CurrencyDetailsApiRespondedListener currencyDetailsApiRespondedListener() {
    return new CurrencyDetailsApiRespondedListener(currencyDetailsRepository);
  }

  @Bean
  QueryHandler<Result, Query> currencyDetailsQueryHandler() {
    return new CurrencyDetailsQueryHandler(currencyDetailsQueryRepository);
  }
}
