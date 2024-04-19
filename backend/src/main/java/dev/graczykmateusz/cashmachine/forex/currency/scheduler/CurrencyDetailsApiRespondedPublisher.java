package dev.graczykmateusz.cashmachine.forex.currency.scheduler;

import dev.graczykmateusz.cashmachine.abstraction.event.DomainEventPublisher;
import dev.graczykmateusz.cashmachine.forex.currency.scheduler.event.CurrencyDetailsForexResponded;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;

@Slf4j
@RequiredArgsConstructor
class CurrencyDetailsApiRespondedPublisher
    implements DomainEventPublisher<CurrencyDetailsForexResponded> {

  private final ApplicationEventPublisher publisher;

  @Override
  public void publish(CurrencyDetailsForexResponded event) {
    log.info("Publishing currency details forex responded event: %s".formatted(event));
    publisher.publishEvent(event);
  }
}
