package dev.graczykmateusz.cashmachine.forex.currency.scheduler;

import dev.graczykmateusz.cashmachine.abstraction.event.DomainEvent;
import dev.graczykmateusz.cashmachine.abstraction.event.DomainEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
class CurrencyDetailsApiRespondedPublisher implements DomainEventPublisher {

  private final ApplicationEventPublisher publisher;

  @Override
  public void publish(DomainEvent event) {
    publisher.publishEvent(event);
  }
}
