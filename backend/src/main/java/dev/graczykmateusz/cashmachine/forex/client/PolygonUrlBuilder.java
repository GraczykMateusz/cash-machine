package dev.graczykmateusz.cashmachine.forex.client;

import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class PolygonUrlBuilder {

  private final ForexClock forexClock;

  String buildCurrent(ExchangeSymbol exchangeSymbol) {
    return "https://api.polygon.io/v2/aggs/ticker/C:"
        + exchangeSymbol
        + "/range/1/minute/"
        + forexClock.getCurrentFrom()
        + "/"
        + forexClock.getCurrentTo()
        + "?limit=5000";
  }

  String buildDaily(ExchangeSymbol exchangeSymbol) {
    return "https://api.polygon.io/v2/aggs/ticker/C:"
        + exchangeSymbol
        + "/range/1/minute/"
        + forexClock.getDailyFrom()
        + "/"
        + forexClock.getDailyTo()
        + "?limit=5000";
  }
}
