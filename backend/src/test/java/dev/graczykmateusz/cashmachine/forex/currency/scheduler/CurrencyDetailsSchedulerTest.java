package dev.graczykmateusz.cashmachine.forex.currency.scheduler;

import static org.assertj.core.api.Assertions.assertThat;

import dev.graczykmateusz.cashmachine.event.ApplicationEventPublisherInMemory;
import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;
import dev.graczykmateusz.cashmachine.forex.currency.scheduler.event.CurrencyDetailsForexResponded;
import java.util.List;
import org.junit.jupiter.api.Test;

class CurrencyDetailsSchedulerTest {

  private final ApplicationEventPublisherInMemory eventPublisher =
      new ApplicationEventPublisherInMemory();

  @Test
  void shouldRetrieveEURPLNApiResponseAndThenPublishItAsCurrencyDetailsForexRespondedEvent() {
    var currencyForexClientStub = new CurrencyForexClientStub(ExchangeSymbol.EURPLN);

    var currencyDetailsScheduler =
        new CurrencyDetailsSchedulerConfiguration(currencyForexClientStub, eventPublisher)
            .currencyDetailsScheduler();

    currencyDetailsScheduler.retrieveEURPLNCurrencyDetails();

    assertThat(eventPublisher.getEvents())
        .containsExactlyElementsOf(
            List.of(new CurrencyDetailsForexResponded(currencyForexClientStub.getResponse())));
  }

  @Test
  void shouldRetrieveUSDPLNApiResponseAndThenPublishItAsCurrencyDetailsForexRespondedEvent() {
    var currencyForexClientStub = new CurrencyForexClientStub(ExchangeSymbol.USDPLN);

    var currencyDetailsScheduler =
        new CurrencyDetailsSchedulerConfiguration(currencyForexClientStub, eventPublisher)
            .currencyDetailsScheduler();

    currencyDetailsScheduler.retrieveUSDPLNCurrencyDetails();

    assertThat(eventPublisher.getEvents())
        .containsExactlyElementsOf(
            List.of(new CurrencyDetailsForexResponded(currencyForexClientStub.getResponse())));
  }

  @Test
  void shouldRetrieveGBPPLNApiResponseAndThenPublishItAsCurrencyDetailsForexRespondedEvent() {
    var currencyForexClientStub = new CurrencyForexClientStub(ExchangeSymbol.GBPPLN);

    var currencyDetailsScheduler =
        new CurrencyDetailsSchedulerConfiguration(currencyForexClientStub, eventPublisher)
            .currencyDetailsScheduler();

    currencyDetailsScheduler.retrieveGBPPLNCurrencyDetails();

    assertThat(eventPublisher.getEvents())
        .containsExactlyElementsOf(
            List.of(new CurrencyDetailsForexResponded(currencyForexClientStub.getResponse())));
  }
}
