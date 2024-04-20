package dev.graczykmateusz.cashmachine.forex.client;

import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyDetailsForexResponseDto;
import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;
import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
class ForexClient implements CurrencyForexClient {

  private final WebClient webClient;
  private final PolygonUrlBuilder polygonUrlBuilder;
  private final PolygonApiSettings polygonApiSettings;

  @Override
  public Mono<CurrencyDetailsForexResponseDto> retrieveCurrentCurrencyDetails(
      ExchangeSymbol exchangeSymbol) {
    String url = polygonUrlBuilder.buildCurrent(exchangeSymbol);
    return retrieveCurrencyDetails(url);
  }

  @Override
  public Mono<CurrencyDetailsForexResponseDto> retrieveDailyCurrencyDetails(
      ExchangeSymbol exchangeSymbol) {
    String url = polygonUrlBuilder.buildDaily(exchangeSymbol);
    return retrieveCurrencyDetails(url);
  }
  
  private Mono<CurrencyDetailsForexResponseDto> retrieveCurrencyDetails(String url) {
    return webClient
            .get()
            .uri(url)
            .header("Authorization", "Bearer " + String.valueOf(polygonApiSettings.apiKey()))
            .retrieve()
            .bodyToMono(CurrencyDetailsForexResponse.class)
            .map(CurrencyDetailsForexResponse::toDto);
  }
}
