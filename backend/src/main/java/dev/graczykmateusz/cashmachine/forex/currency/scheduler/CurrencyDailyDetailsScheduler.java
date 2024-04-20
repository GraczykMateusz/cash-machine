package dev.graczykmateusz.cashmachine.forex.currency.scheduler;

import static dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol.*;

import dev.graczykmateusz.cashmachine.abstraction.event.DomainEventPublisher;
import dev.graczykmateusz.cashmachine.forex.client.CurrencyForexClient;
import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;
import dev.graczykmateusz.cashmachine.forex.currency.scheduler.event.DailyCurrencyDetailsForexResponded;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@RequiredArgsConstructor
class CurrencyDailyDetailsScheduler {

  private final CurrencyForexClient currencyForexClient;
  private final DomainEventPublisher<DailyCurrencyDetailsForexResponded> publisher;

  @Async
  @Scheduled(cron = "0 0 0 * * *")
  public void retrieveDailyEURPLNCurrencyDetails() {
    retrieveDailyCurrencyDetails(EURPLN);
  }

  @Async
  @Scheduled(cron = "0 0 0 * * *")
  public void retrieveDailyUSDPLNCurrencyDetails() {
    retrieveDailyCurrencyDetails(USDPLN);
  }

  private void retrieveDailyCurrencyDetails(ExchangeSymbol exchangeSymbol) {
    var currencyDetailsApiResponse =
        currencyForexClient.retrieveDailyCurrencyDetails(exchangeSymbol);

    currencyDetailsApiResponse.subscribe(
        currencyDetailsForexResponseDto ->
            publisher.publish(
                new DailyCurrencyDetailsForexResponded(currencyDetailsForexResponseDto)));
  }
}
