package dev.graczykmateusz.cashmachine.forex.currency.scheduler;

import dev.graczykmateusz.cashmachine.forex.client.exception.EmptyCurrencyPriceListException;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ForexApiErrorConsumer implements Consumer<Throwable> {

  @Override
  public void accept(Throwable throwable) {
    if (throwable instanceof EmptyCurrencyPriceListException) {
      log.info("Empty currency price list");
    }
  }
}
