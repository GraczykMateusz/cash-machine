package dev.graczykmateusz.cashmachine.forex.currency.scheduler;

import dev.graczykmateusz.cashmachine.forex.client.CurrencyForexClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CurrencyDetailsSchedulerConfiguration {

  @Bean
  CurrencyDetailsScheduler currencyDetailsScheduler(CurrencyForexClient currencyForexClient) {
    var forexApiRespondedPublisher = new CurrencyDetailsApiRespondedPublisher();
    return new CurrencyDetailsScheduler(currencyForexClient, forexApiRespondedPublisher);
  }
}
