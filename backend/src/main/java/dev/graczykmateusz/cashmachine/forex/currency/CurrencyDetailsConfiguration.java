package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.abstraction.event.DomainEventListener;
import dev.graczykmateusz.cashmachine.abstraction.query.QueryHandler;
import dev.graczykmateusz.cashmachine.api.query.GetAllCurrencyDetails;
import dev.graczykmateusz.cashmachine.forex.currency.dto.AllCurrencyDetailsDto;
import dev.graczykmateusz.cashmachine.forex.currency.scheduler.event.CurrencyDetailsForexResponded;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@RequiredArgsConstructor
class CurrencyDetailsConfiguration {

  private final CurrencyDetailsRepository currencyDetailsRepository;
  private final CurrencyDetailsQueryRepository currencyDetailsQueryRepository;

  @Bean
  DomainEventListener<CurrencyDetailsForexResponded> currencyDetailsApiRespondedListener() {
    return new CurrencyDetailsApiRespondedListener(currencyDetailsRepository);
  }

  @Bean
  QueryHandler<AllCurrencyDetailsDto, GetAllCurrencyDetails> currencyDetailsQueryHandler() {
    return new GetAllCurrencyDetailsQueryHandler(currencyDetailsQueryRepository);
  }
}
