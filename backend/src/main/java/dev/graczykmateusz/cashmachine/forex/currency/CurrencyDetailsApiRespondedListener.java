package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.abstraction.event.DomainEventListener;
import dev.graczykmateusz.cashmachine.forex.currency.scheduler.event.CurrencyDetailsForexResponded;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

@RequiredArgsConstructor
class CurrencyDetailsApiRespondedListener
    implements DomainEventListener<CurrencyDetailsForexResponded> {

  private final CurrencyDetailsRepository currencyDetailsRepository;

  @Async
  @EventListener
  @Override
  public void listen(CurrencyDetailsForexResponded event) {
    var eventData = event.currencyDetailsForexResponseDto();
    var currencyDetails = CurrencyDetails.toDomain(eventData);
    currencyDetailsRepository.save(currencyDetails);
  }
}