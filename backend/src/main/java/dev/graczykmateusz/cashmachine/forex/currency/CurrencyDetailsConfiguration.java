package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.abstraction.command.CommandHandler;
import dev.graczykmateusz.cashmachine.abstraction.event.DomainEventListener;
import dev.graczykmateusz.cashmachine.abstraction.query.QueryHandler;
import dev.graczykmateusz.cashmachine.forex.client.CurrencyForexClient;
import dev.graczykmateusz.cashmachine.forex.currency.command.RemoveAllCurrencyDetails;
import dev.graczykmateusz.cashmachine.forex.currency.command.UpdateDailyCurrencyDetails;
import dev.graczykmateusz.cashmachine.forex.currency.dto.AllCurrencyDetailsDto;
import dev.graczykmateusz.cashmachine.forex.currency.dto.CurrencyDetailsDto;
import dev.graczykmateusz.cashmachine.forex.currency.query.GetAllCurrencyDetails;
import dev.graczykmateusz.cashmachine.forex.currency.query.GetCurrencyDetails;
import dev.graczykmateusz.cashmachine.forex.currency.scheduler.event.CurrentCurrencyDetailsForexResponded;
import dev.graczykmateusz.cashmachine.forex.currency.scheduler.event.DailyCurrencyDetailsForexResponded;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
class CurrencyDetailsConfiguration {
  
  private final CurrencyDetailsGrouper grouper = new CurrencyDetailsGrouper();
  
  @Bean
  CommandHandler<UpdateDailyCurrencyDetails> updateLastWeekCurrencyDetailsCommandHandler(
      CurrencyForexClient client, CurrencyDetailsRepository repository) {
    return new UpdateDailyCurrencyDetailsCommandHandler(client, repository);
  }

  @Bean
  CommandHandler<RemoveAllCurrencyDetails> removeAllCurrencyDetailsCommandHandler(
      CurrencyDetailsRepository repository) {
    return new RemoveAllCurrencyDetailsCommandHandler(repository);
  }

  @Bean
  DomainEventListener<CurrentCurrencyDetailsForexResponded> currencyDetailsApiRespondedListener(
      CurrencyDetailsRepository repository) {
    return new CurrentCurrencyDetailsApiRespondedListener(repository);
  }

  @Bean
  DomainEventListener<DailyCurrencyDetailsForexResponded> dailyCurrencyDetailsApiRespondedListener(
      CurrencyDetailsRepository repository) {
    return new DailyCurrencyDetailsApiRespondedListener(repository);
  }

  @Bean
  QueryHandler<AllCurrencyDetailsDto, GetAllCurrencyDetails> getAllCurrencyDetailsQueryHandler(
      CurrencyDetailsQueryRepository queryRepository) {
    return new GetAllCurrencyDetailsQueryHandler(grouper, queryRepository);
  }
  
  @Bean
  QueryHandler<CurrencyDetailsDto, GetCurrencyDetails> getCurrencyDetailsQueryHandler(
          CurrencyDetailsQueryRepository queryRepository) {
    return new GetCurrencyDetailsQueryHandler(grouper, queryRepository);
  }
}
