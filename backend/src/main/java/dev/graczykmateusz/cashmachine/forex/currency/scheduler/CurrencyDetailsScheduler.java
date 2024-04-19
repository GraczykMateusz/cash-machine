package dev.graczykmateusz.cashmachine.forex.currency.scheduler;

import static dev.graczykmateusz.cashmachine.forex.constants.AvailableCurrencyPair.*;

import dev.graczykmateusz.cashmachine.abstraction.event.DomainEventPublisher;
import dev.graczykmateusz.cashmachine.forex.client.CurrencyForexClient;
import dev.graczykmateusz.cashmachine.forex.currency.scheduler.event.CurrencyDetailsForexResponded;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@RequiredArgsConstructor
class CurrencyDetailsScheduler {

  private final CurrencyForexClient currencyForexClient;
  private final DomainEventPublisher<CurrencyDetailsForexResponded> publisher;

  @Scheduled(fixedDelay = 60000)
  void retrieveEURPLNCurrencyDetails() {
    var currencyDetailsApiResponse = currencyForexClient.retrieveCurrencyDetails(EURPLN);
    currencyDetailsApiResponse.subscribe(
        currencyDetailsForexResponseDto -> {
          log.debug(
              "Got currency details API (EURPLN) response: {}", currencyDetailsForexResponseDto);
          publisher.publish(new CurrencyDetailsForexResponded(currencyDetailsForexResponseDto));
        });
  }

  @Scheduled(fixedDelay = 60000)
  void retrieveUSDPLNCurrencyDetails() {
    var currencyDetailsApiResponse = currencyForexClient.retrieveCurrencyDetails(USDPLN);
    currencyDetailsApiResponse.subscribe(
        currencyDetailsForexResponseDto -> {
          log.debug(
              "Got currency details API (USDPLN) response: {}", currencyDetailsForexResponseDto);
          publisher.publish(new CurrencyDetailsForexResponded(currencyDetailsForexResponseDto));
        });
  }

  @Scheduled(fixedDelay = 60000)
  void retrieveGBPPLNCurrencyDetails() {
    var currencyDetailsApiResponse = currencyForexClient.retrieveCurrencyDetails(GBPPLN);
    currencyDetailsApiResponse.subscribe(
        currencyDetailsForexResponseDto -> {
          log.debug(
              "Got currency details API (GBPPLN) response: {}", currencyDetailsForexResponseDto);
          publisher.publish(new CurrencyDetailsForexResponded(currencyDetailsForexResponseDto));
        });
  }
}
