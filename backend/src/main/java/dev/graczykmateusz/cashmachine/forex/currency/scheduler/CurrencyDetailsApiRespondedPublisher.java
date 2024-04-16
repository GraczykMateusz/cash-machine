package dev.graczykmateusz.cashmachine.forex.currency.scheduler;

import dev.graczykmateusz.cashmachine.abstraction.event.DomainEventPublisher;
import dev.graczykmateusz.cashmachine.forex.currency.scheduler.event.CurrencyDetailsForexResponded;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
class CurrencyDetailsApiRespondedPublisher
    implements DomainEventPublisher<CurrencyDetailsForexResponded> {

  private final ApplicationEventPublisher publisher;

  @Override
  public void publish(CurrencyDetailsForexResponded event) {
    publisher.publishEvent(event);
  }
}
