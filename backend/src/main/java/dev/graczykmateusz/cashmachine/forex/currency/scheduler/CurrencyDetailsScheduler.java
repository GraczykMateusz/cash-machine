package dev.graczykmateusz.cashmachine.forex.currency.scheduler;

import static dev.graczykmateusz.cashmachine.forex.constants.AvailableCurrencyPair.*;

import dev.graczykmateusz.cashmachine.abstraction.event.DomainEventPublisher;
import dev.graczykmateusz.cashmachine.forex.client.CurrencyForexClient;
import dev.graczykmateusz.cashmachine.forex.currency.scheduler.event.CurrencyDetailsForexResponded;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;

@RequiredArgsConstructor
class CurrencyDetailsScheduler {

  private final CurrencyForexClient currencyForexClient;
  private final DomainEventPublisher<CurrencyDetailsForexResponded> publisher;

  @Scheduled(fixedDelay = 60000)
  void retrieveEURPLNCurrencyDetails() {
    var currencyDetailsApiResponse = currencyForexClient.retrieveCurrencyDetails(EURPLN);
    System.out.println(Thread.currentThread().getName());
    currencyDetailsApiResponse.subscribe(
            currencyDetailsForexResponseDto -> {
              System.out.println("THREAD ->" + Thread.currentThread().getName() + "; VALUE ->" + currencyDetailsForexResponseDto);
              publisher.publish(new CurrencyDetailsForexResponded(currencyDetailsForexResponseDto));
            });
  }

  @Scheduled(fixedDelay = 60000)
  void retrieveUSDPLNCurrencyDetails() {
    var currencyDetailsApiResponse = currencyForexClient.retrieveCurrencyDetails(USDPLN);
    System.out.println(Thread.currentThread().getName());
    currencyDetailsApiResponse.subscribe(
        currencyDetailsForexResponseDto -> {
          System.out.println("THREAD ->" + Thread.currentThread().getName() + "; VALUE ->" + currencyDetailsForexResponseDto);
          publisher.publish(new CurrencyDetailsForexResponded(currencyDetailsForexResponseDto));
        });
  }

  @Scheduled(fixedDelay = 60000)
  void retrieveGBPPLNCurrencyDetails() {
    var currencyDetailsApiResponse = currencyForexClient.retrieveCurrencyDetails(GBPPLN);
    System.out.println(Thread.currentThread().getName());
    currencyDetailsApiResponse.subscribe(
            currencyDetailsForexResponseDto -> {
              System.out.println("THREAD ->" + Thread.currentThread().getName() + "; VALUE ->" + currencyDetailsForexResponseDto);
              publisher.publish(new CurrencyDetailsForexResponded(currencyDetailsForexResponseDto));
            });
  }
}
