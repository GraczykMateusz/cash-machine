package dev.graczykmateusz.cashmachine.forex.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
class ForexClient {

  private final WebClient webClient;
  private final PolygonApiSettings polygonApiSettings;

  ForexApiResponse getForexData() {
    String url = polygonApiSettings.url();
    String api = polygonApiSettings.apiKey();
    return webClient
        .get()
        .uri(
            url
                + "C:EURPLN/range/1/day/2023-01-09/2023-01-09?adjusted=true&sort=asc&limit=120&apiKey="
                + api)
        .retrieve()
        .bodyToMono(ForexApiResponse.class)
        .block();
  }
}
