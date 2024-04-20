package dev.graczykmateusz.cashmachine.forex.currency.scheduler;

import dev.graczykmateusz.cashmachine.forex.client.CurrencyForexClient;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
class CurrencyDetailsSchedulerConfiguration {

  @Bean
  CurrencyCurrentDetailsScheduler currencyDetailsScheduler(
      CurrencyForexClient currencyForexClient,
      ApplicationEventPublisher applicationEventPublisher) {
    var eventPublisher = new CurrencyCurrentDetailsApiRespondedPublisher(applicationEventPublisher);
    return new CurrencyCurrentDetailsScheduler(currencyForexClient, eventPublisher);
  }

  @Bean
  CurrencyDailyDetailsScheduler currencyDailyDetailsScheduler(
      CurrencyForexClient currencyForexClient,
      ApplicationEventPublisher applicationEventPublisher) {
    var eventPublisher = new CurrencyDailyDetailsApiRespondedPublisher(applicationEventPublisher);
    return new CurrencyDailyDetailsScheduler(currencyForexClient, eventPublisher);
  }
}
