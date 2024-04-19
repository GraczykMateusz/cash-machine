package dev.graczykmateusz.cashmachine.forex.client;

import java.time.Clock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration(proxyBeanMethods = false)
class ForexClientConfiguration {

  private final Clock clock;
  private final WebClient webClient;
  private final char[] apiKey;

  ForexClientConfiguration(
      Clock clock, WebClient webClient, @Value("${polygon.api.key}") char[] apiKey) {
    this.clock = clock;
    this.webClient = webClient;
    this.apiKey = apiKey;
  }

  @Bean
  ForexClient forexClient() {
    var polygonApiSettings = new PolygonApiSettings(apiKey);
    var forexClock = new ForexClock(clock);
    var polygonUrlBuilder = new PolygonUrlBuilder(forexClock);
    return new ForexClient(webClient, polygonUrlBuilder, polygonApiSettings);
  }
}
