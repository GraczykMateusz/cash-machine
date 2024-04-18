package dev.graczykmateusz.cashmachine.forex.client;

import dev.graczykmateusz.cashmachine.forex.constants.AvailableCurrencyPair;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class PolygonUrlBuilder {

  private final ForexClock forexClock;

  String build(AvailableCurrencyPair availableCurrencyPair) {
    return "https://api.polygon.io/v2/aggs/ticker/C:"
        + availableCurrencyPair
        + "/range/1/minute/"
        + forexClock.getFrom()
        + "/"
        + forexClock.getTo()
        + "?adjusted=true&sort=asc&limit=1";
  }
}
