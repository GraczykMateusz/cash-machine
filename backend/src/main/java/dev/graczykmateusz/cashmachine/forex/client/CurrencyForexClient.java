package dev.graczykmateusz.cashmachine.forex.client;

import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyDetailsForexResponseDto;

public interface CurrencyForexClient {
    
    CurrencyDetailsForexResponseDto retrieveCurrencyDetails();
}
