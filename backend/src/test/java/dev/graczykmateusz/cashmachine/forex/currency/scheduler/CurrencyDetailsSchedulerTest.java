package dev.graczykmateusz.cashmachine.forex.currency.scheduler;

import static org.assertj.core.api.Assertions.assertThat;

import dev.graczykmateusz.cashmachine.event.ApplicationEventPublisherInMemory;
import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyDetailsForexResponseDto;
import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyPriceForexResponseDto;
import dev.graczykmateusz.cashmachine.forex.currency.scheduler.event.CurrencyDetailsForexResponded;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;

class CurrencyDetailsSchedulerTest {

  private final List<CurrencyPriceForexResponseDto> currencyPriceForexResponseDto =
      List.of(
          new CurrencyPriceForexResponseDto(
              BigDecimal.valueOf(0),
              BigDecimal.valueOf(1),
              BigDecimal.valueOf(2),
              BigDecimal.valueOf(3),
              BigDecimal.valueOf(4),
              BigDecimal.valueOf(5),
              BigDecimal.valueOf(6),
              BigDecimal.valueOf(7)));

  private final CurrencyForexClientStub currencyForexClient =
      new CurrencyForexClientStub("exchangeSymbol", currencyPriceForexResponseDto);

  private final ApplicationEventPublisherInMemory eventPublisher =
      new ApplicationEventPublisherInMemory();

  private final CurrencyDetailsScheduler currencyDetailsScheduler =
      new CurrencyDetailsSchedulerConfiguration(currencyForexClient, eventPublisher)
          .currencyDetailsScheduler();

  @Test
  void shouldRetrieveEURPLNApiResponseAndThenPublishItAsCurrencyDetailsForexRespondedEvent() {
    currencyDetailsScheduler.retrieveEURPLNCurrencyDetails();
    List<Object> events = eventPublisher.getEvents();
    assertThat(events)
        .containsExactlyElementsOf(
            List.of(
                new CurrencyDetailsForexResponded(
                    new CurrencyDetailsForexResponseDto(
                        "exchangeSymbol", currencyPriceForexResponseDto))));
  }

  @Test
  void shouldRetrieveUSDPLNApiResponseAndThenPublishItAsCurrencyDetailsForexRespondedEvent() {
    currencyDetailsScheduler.retrieveUSDPLNCurrencyDetails();
    List<Object> events = eventPublisher.getEvents();
    assertThat(events)
        .containsExactlyElementsOf(
            List.of(
                new CurrencyDetailsForexResponded(
                    new CurrencyDetailsForexResponseDto(
                        "exchangeSymbol", currencyPriceForexResponseDto))));
  }

  @Test
  void shouldRetrieveGBPPLNApiResponseAndThenPublishItAsCurrencyDetailsForexRespondedEvent() {
    currencyDetailsScheduler.retrieveGBPPLNCurrencyDetails();
    List<Object> events = eventPublisher.getEvents();
    assertThat(events)
        .containsExactlyElementsOf(
            List.of(
                new CurrencyDetailsForexResponded(
                    new CurrencyDetailsForexResponseDto(
                        "exchangeSymbol", currencyPriceForexResponseDto))));
  }
}
