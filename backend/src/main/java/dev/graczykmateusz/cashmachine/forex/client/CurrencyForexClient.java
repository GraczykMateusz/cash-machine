package dev.graczykmateusz.cashmachine.forex.client;

import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyDetailsForexResponseDto;
import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;
import reactor.core.publisher.Mono;

public interface CurrencyForexClient {
    
    Mono<CurrencyDetailsForexResponseDto> retrieveCurrencyDetails(ExchangeSymbol exchangeSymbol);
    
    Mono<CurrencyDetailsForexResponseDto> retrieveHistoricalDetails(ExchangeSymbol exchangeSymbol);
}
