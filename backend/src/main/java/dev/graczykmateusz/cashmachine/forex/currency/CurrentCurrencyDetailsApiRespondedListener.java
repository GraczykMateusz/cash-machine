package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.abstraction.event.DomainEventListener;
import dev.graczykmateusz.cashmachine.forex.currency.scheduler.event.CurrentCurrencyDetailsForexResponded;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

@RequiredArgsConstructor
class CurrentCurrencyDetailsApiRespondedListener
    implements DomainEventListener<CurrentCurrencyDetailsForexResponded> {

  private final CurrencyDetailsRepository repository;

  @Async
  @EventListener
  @Override
  public void listen(CurrentCurrencyDetailsForexResponded event) {
    var eventData = event.currencyDetailsForexResponseDto();
    var currencyDetails = CurrencyDetailsMapper.fromDto(eventData);
    repository.save(currencyDetails);
  }
}
