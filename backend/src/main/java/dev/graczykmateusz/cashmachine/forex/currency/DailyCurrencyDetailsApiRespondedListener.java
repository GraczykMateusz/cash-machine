package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.abstraction.event.DomainEventListener;
import dev.graczykmateusz.cashmachine.forex.currency.scheduler.event.DailyCurrencyDetailsForexResponded;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

@RequiredArgsConstructor
class DailyCurrencyDetailsApiRespondedListener
    implements DomainEventListener<DailyCurrencyDetailsForexResponded> {

  private final CurrencyDetailsRepository repository;

  @Async
  @EventListener
  @Override
  public void listen(DailyCurrencyDetailsForexResponded event) {
    var eventData = event.currencyDetailsForexResponseDto();
    var currencyDetails = CurrencyDetailsMapper.fromDto(eventData);
    repository.deleteAll();
    repository.save(currencyDetails);
  }
}
