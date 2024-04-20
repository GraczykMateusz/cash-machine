package dev.graczykmateusz.cashmachine.forex.currency.scheduler;

import static dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol.*;

import dev.graczykmateusz.cashmachine.abstraction.event.DomainEventPublisher;
import dev.graczykmateusz.cashmachine.forex.client.CurrencyForexClient;
import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;
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
    retrieveCurrencyDetails(EURPLN);
  }

  @Scheduled(fixedDelay = 60000)
  void retrieveUSDPLNCurrencyDetails() {
    retrieveCurrencyDetails(USDPLN);
  }

  @Scheduled(fixedDelay = 60000)
  void retrieveGBPPLNCurrencyDetails() {
    retrieveCurrencyDetails(GBPPLN);
  }

  private void retrieveCurrencyDetails(ExchangeSymbol exchangeSymbol) {
    var currencyDetailsApiResponse =
        currencyForexClient.retrieveCurrencyDetails(exchangeSymbol);
    
    currencyDetailsApiResponse.subscribe(
        currencyDetailsForexResponseDto ->
            publisher.publish(new CurrencyDetailsForexResponded(currencyDetailsForexResponseDto)));
  }
}
