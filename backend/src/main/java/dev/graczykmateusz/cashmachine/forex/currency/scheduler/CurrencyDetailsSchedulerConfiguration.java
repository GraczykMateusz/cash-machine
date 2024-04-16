package dev.graczykmateusz.cashmachine.forex.currency.scheduler;

import dev.graczykmateusz.cashmachine.forex.client.CurrencyForexClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@RequiredArgsConstructor
class CurrencyDetailsSchedulerConfiguration {

  private final CurrencyForexClient currencyForexClient;
  private final ApplicationEventPublisher applicationEventPublisher;

  @Bean
  CurrencyDetailsScheduler currencyDetailsScheduler() {
    var forexApiRespondedPublisher =
        new CurrencyDetailsApiRespondedPublisher(applicationEventPublisher);
    return new CurrencyDetailsScheduler(currencyForexClient, forexApiRespondedPublisher);
  }
}
