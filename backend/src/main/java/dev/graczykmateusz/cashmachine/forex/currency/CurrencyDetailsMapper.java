package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyDetailsForexResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class CurrencyDetailsMapper {
    
    static CurrencyDetails toDomain(CurrencyDetailsForexResponseDto currencyDetailsForexResponse) {
//        new CurrencyDetails(currencyDetailsForexResponse.exchangeSymbol(),)
    }
}
