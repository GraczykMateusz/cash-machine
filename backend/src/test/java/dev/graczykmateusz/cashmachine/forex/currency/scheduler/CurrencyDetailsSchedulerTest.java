package dev.graczykmateusz.cashmachine.forex.currency.scheduler;

import dev.graczykmateusz.cashmachine.event.ApplicationEventPublisherInMemory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CurrencyDetailsSchedulerTest {

  private final ApplicationEventPublisherInMemory eventPublisher = new ApplicationEventPublisherInMemory();
  private final CurrencyForexClientStub currencyForexClient = new CurrencyForexClientStub();
  
  private final CurrencyDetailsScheduler currencyDetailsScheduler =
      new CurrencyDetailsSchedulerConfiguration(currencyForexClient, eventPublisher)
          .currencyDetailsScheduler();

  @Test
  void shouldRetrieveEURPLNApiResponseAndThenPublishItAsCurrencyDetailsForexRespondedEvent() {
    currencyDetailsScheduler.retrieveEURPLNCurrencyDetails();
    List<Object> events = eventPublisher.getEvents();
    assertThat(events).hasSize(1);
  }
  
  @Test
  void shouldRetrieveUSDPLNApiResponseAndThenPublishItAsCurrencyDetailsForexRespondedEvent() {
    currencyDetailsScheduler.retrieveUSDPLNCurrencyDetails();
    List<Object> events = eventPublisher.getEvents();
    assertThat(events).hasSize(1);
  }
  
  @Test
  void shouldRetrieveGBPPLNApiResponseAndThenPublishItAsCurrencyDetailsForexRespondedEvent() {
    currencyDetailsScheduler.retrieveGBPPLNCurrencyDetails();
    List<Object> events = eventPublisher.getEvents();
    assertThat(events).hasSize(1);
  }
}
