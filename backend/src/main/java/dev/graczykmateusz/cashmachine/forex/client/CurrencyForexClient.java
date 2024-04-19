package dev.graczykmateusz.cashmachine.forex.client;

import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyDetailsForexResponseDto;
import dev.graczykmateusz.cashmachine.forex.constants.AvailableCurrencyPair;
import reactor.core.publisher.Mono;

public interface CurrencyForexClient {
    
    Mono<CurrencyDetailsForexResponseDto> retrieveCurrencyDetails(AvailableCurrencyPair availableCurrencyPair);
    
    Mono<CurrencyDetailsForexResponseDto> retrieveHistoricalDetails(AvailableCurrencyPair availableCurrencyPair);
}
