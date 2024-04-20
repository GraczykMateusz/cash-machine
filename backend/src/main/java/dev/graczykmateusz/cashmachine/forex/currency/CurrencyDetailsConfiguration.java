package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.abstraction.event.DomainEventListener;
import dev.graczykmateusz.cashmachine.abstraction.query.QueryHandler;
import dev.graczykmateusz.cashmachine.api.query.GetAllCurrencyDetails;
import dev.graczykmateusz.cashmachine.forex.currency.dto.AllCurrencyDetailsDto;
import dev.graczykmateusz.cashmachine.forex.currency.scheduler.event.CurrencyDetailsForexResponded;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
class CurrencyDetailsConfiguration {

  private final CurrencyDetailsRepository repository;
  private final CurrencyDetailsQueryRepository queryRepository;

  CurrencyDetailsConfiguration(
      CurrencyDetailsRepository repository, CurrencyDetailsQueryRepository queryRepository) {
    this.repository = repository;
    this.queryRepository = queryRepository;
  }

  @Bean
  DomainEventListener<CurrencyDetailsForexResponded> currencyDetailsApiRespondedListener() {
    return new CurrencyDetailsApiRespondedListener(repository);
  }

  @Bean
  QueryHandler<AllCurrencyDetailsDto, GetAllCurrencyDetails> currencyDetailsQueryHandler() {
    var grouper = new CurrencyDetailsGrouper();
    return new GetAllCurrencyDetailsQueryHandler(grouper, queryRepository);
  }
}
