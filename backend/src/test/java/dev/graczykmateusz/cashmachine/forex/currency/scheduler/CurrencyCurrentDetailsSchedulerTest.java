package dev.graczykmateusz.cashmachine.forex.currency.scheduler;

import static org.assertj.core.api.Assertions.assertThat;

import dev.graczykmateusz.cashmachine.event.ApplicationEventPublisherInMemory;
import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;
import dev.graczykmateusz.cashmachine.forex.currency.scheduler.event.CurrentCurrencyDetailsForexResponded;
import java.util.List;
import org.junit.jupiter.api.Test;

class CurrencyCurrentDetailsSchedulerTest {

  private final ApplicationEventPublisherInMemory eventPublisher =
      new ApplicationEventPublisherInMemory();

  @Test
  void shouldRetrieveEURPLNApiResponseAndThenPublishItAsCurrencyDetailsForexRespondedEvent() {
    var currencyForexClientStub = new CurrencyForexClientStub(ExchangeSymbol.EURPLN);

    var currencyDetailsScheduler =
        new CurrencyDetailsSchedulerConfiguration()
            .currencyDetailsScheduler(currencyForexClientStub, eventPublisher);

    currencyDetailsScheduler.retrieveCurrentEURPLNCurrencyDetails();

    assertThat(eventPublisher.getEvents())
        .containsExactlyElementsOf(
            List.of(new CurrentCurrencyDetailsForexResponded(currencyForexClientStub.getResponse())));
  }

  @Test
  void shouldRetrieveUSDPLNApiResponseAndThenPublishItAsCurrencyDetailsForexRespondedEvent() {
    var currencyForexClientStub = new CurrencyForexClientStub(ExchangeSymbol.USDPLN);

    var currencyDetailsScheduler =
        new CurrencyDetailsSchedulerConfiguration()
            .currencyDetailsScheduler(currencyForexClientStub, eventPublisher);

    currencyDetailsScheduler.retrieveCurrentUSDPLNCurrencyDetails();

    assertThat(eventPublisher.getEvents())
        .containsExactlyElementsOf(
            List.of(new CurrentCurrencyDetailsForexResponded(currencyForexClientStub.getResponse())));
  }
}
