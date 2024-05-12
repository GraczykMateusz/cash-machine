package dev.graczykmateusz.cashmachine.forex.currency.scheduler;

import static dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol.*;

import dev.graczykmateusz.cashmachine.abstraction.event.DomainEventPublisher;
import dev.graczykmateusz.cashmachine.forex.client.CurrencyForexClient;
import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;
import dev.graczykmateusz.cashmachine.forex.currency.scheduler.event.CurrentCurrencyDetailsForexResponded;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@RequiredArgsConstructor
class CurrencyCurrentDetailsScheduler {

  private final ForexApiErrorConsumer errorConsumer;
  private final CurrencyForexClient currencyForexClient;
  private final DomainEventPublisher<CurrentCurrencyDetailsForexResponded> publisher;

  @Async
  @Scheduled(cron = "0 * * * * *")
  public void retrieveCurrentEURPLNCurrencyDetails() {
    retrieveCurrentCurrencyDetails(EURPLN);
  }

  @Async
  @Scheduled(cron = "0 * * * * *")
  public void retrieveCurrentUSDPLNCurrencyDetails() {
    retrieveCurrentCurrencyDetails(USDPLN);
  }

  private void retrieveCurrentCurrencyDetails(ExchangeSymbol exchangeSymbol) {
    var currencyDetailsApiResponse =
        currencyForexClient.retrieveCurrentCurrencyDetails(exchangeSymbol);

    currencyDetailsApiResponse
        .doOnError(errorConsumer)
        .subscribe(
            currencyDetailsForexResponseDto ->
                publisher.publish(
                    new CurrentCurrencyDetailsForexResponded(currencyDetailsForexResponseDto)));
  }
}
