package dev.graczykmateusz.cashmachine.forex.scheduler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
class ForexSchedulerConfiguration {

  @Bean
  ForexScheduler forexSheduler(
      WebClient webClient,
      @Value("${polygon.aggs.api.url}") String url,
      @Value("${polygon.api.key}") String apiKey) {

    var polygonApiSettings = new PolygonApiSettings(url, apiKey);
    var forexClient = new ForexClient(webClient, polygonApiSettings);
    var forexApiRespondedPublisher = new ForexApiRespondedPublisher();
    
    return new ForexScheduler(forexClient, forexApiRespondedPublisher);
  }
}
