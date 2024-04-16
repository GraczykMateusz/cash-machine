package dev.graczykmateusz.cashmachine.forex.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
class ForexClientConfiguration {
  
  @Bean
  ForexClient forexClient(
      WebClient webClient,
      @Value("${polygon.aggs.api.url}") String url,
      @Value("${polygon.api.key}") String apiKey) {
    var polygonApiSettings = new PolygonApiSettings(url, apiKey);
    return new ForexClient(webClient, polygonApiSettings);
  }
}
