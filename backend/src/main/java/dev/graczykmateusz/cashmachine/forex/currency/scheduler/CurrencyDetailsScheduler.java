package dev.graczykmateusz.cashmachine.forex.currency.scheduler;

import dev.graczykmateusz.cashmachine.forex.client.CurrencyForexClient;
import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyDetailsForexResponseDto;
import dev.graczykmateusz.cashmachine.forex.currency.scheduler.event.CurrencyDetailsForexResponded;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;

@RequiredArgsConstructor
class CurrencyDetailsScheduler {

  private final CurrencyForexClient currencyForexClient;
  private final CurrencyDetailsApiRespondedPublisher publisher;

  @Scheduled(fixedDelay = 60000)
  void updateCurrencyDetails() {
    CurrencyDetailsForexResponseDto currencyDetailsApiResponse =
        currencyForexClient.retrieveCurrencyDetails();
    publisher.publish(new CurrencyDetailsForexResponded(currencyDetailsApiResponse));
  }
}
