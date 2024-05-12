package dev.graczykmateusz.cashmachine.forex.client;

import static dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol.USDPLN;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

class ForexClientTest {

//  private final WebClient webClient =
//      WebClient.builder()
//          .exchangeFunction(
//              clientRequest ->
//                  Mono.just(
//                      ClientResponse.create(HttpStatus.OK)
//                          .header("content-type", "application/json")
//                          .body()
//                          .build()))
//          .build();
//
//  private final Clock clock =
//      Clock.fixed(Instant.parse("2007-12-03T10:15:30.00Z"), ZoneId.systemDefault());
//
//  private final ForexClient forexClient =
//      new ForexClientConfiguration().forexClient(clock, webClient, "POLYGON_API_KEY".toCharArray());
//
//  @Test
//  void retrieveCurrentCurrencyDetails() {
//    var currencyDetailsForexResponseMono = forexClient.retrieveCurrentCurrencyDetails(USDPLN);
//  }
}
