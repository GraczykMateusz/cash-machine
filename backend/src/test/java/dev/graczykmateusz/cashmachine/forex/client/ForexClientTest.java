package dev.graczykmateusz.cashmachine.forex.client;

import static dev.graczykmateusz.cashmachine.forex.constants.AvailableCurrencyPair.GBPPLN;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.reactive.function.client.WebClient;

class ForexClientTest {

  private final WebClient webClient = Mockito.mock(WebClient.class);
  
  private final Clock clock =
      Clock.fixed(Instant.parse("2007-12-03T10:15:30.00Z"), ZoneId.systemDefault());

  private final ForexClient forexClient =
      new ForexClientConfiguration(clock, webClient, "POLYGON_API_KEY".toCharArray()).forexClient();

  @Test
  void retrieveCurrencyDetails() {
    var currencyDetailsForexResponseDto = forexClient.retrieveCurrencyDetails(GBPPLN).block();
  }
}
