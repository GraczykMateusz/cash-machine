package dev.graczykmateusz.cashmachine.forex.currency.scheduler;

import dev.graczykmateusz.cashmachine.abstraction.event.DomainEventPublisher;
import dev.graczykmateusz.cashmachine.forex.client.CurrencyForexClient;
import dev.graczykmateusz.cashmachine.forex.currency.scheduler.event.CurrencyDetailsForexResponded;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;

@RequiredArgsConstructor
class CurrencyDetailsScheduler {

  private final CurrencyForexClient currencyForexClient;
  private final DomainEventPublisher<CurrencyDetailsForexResponded> publisher;

  @Scheduled(fixedDelay = 60000)
  void retrieveCurrencyDetails() {
    var currencyDetailsApiResponse = currencyForexClient.retrieveCurrencyDetails();
    publisher.publish(new CurrencyDetailsForexResponded(currencyDetailsApiResponse));
  }
}
