package dev.graczykmateusz.cashmachine.forex.currency.scheduler;

import dev.graczykmateusz.cashmachine.abstraction.event.DomainEventPublisher;
import dev.graczykmateusz.cashmachine.forex.currency.scheduler.event.DailyCurrencyDetailsForexResponded;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;

@Slf4j
@RequiredArgsConstructor
class CurrencyDailyDetailsApiRespondedPublisher
    implements DomainEventPublisher<DailyCurrencyDetailsForexResponded> {

  private final ApplicationEventPublisher publisher;

  @Override
  public void publish(DailyCurrencyDetailsForexResponded event) {
    log.info("Publishing event: %s".formatted(event.currencyDetailsForexResponseDto().exchangeSymbol()));
    publisher.publishEvent(event);
  }
}
