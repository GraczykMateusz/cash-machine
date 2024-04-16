package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyDetailsForexResponseDto;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class CurrencyDetails {

  @Id private String id;
  private String exchangeSymbol;
  private List<CurrencyPrice> currencyPrices;

  CurrencyDetails(String exchangeSymbol, List<CurrencyPrice> currencyPrices) {
    this.exchangeSymbol = exchangeSymbol;
    this.currencyPrices = currencyPrices;
  }

  static CurrencyDetails toDomain(CurrencyDetailsForexResponseDto currencyDetailsForexResponseDto) {
    return new CurrencyDetails(
        currencyDetailsForexResponseDto.exchangeSymbol(),
        currencyDetailsForexResponseDto.currencyPrices().stream()
            .map(CurrencyPrice::toDomain)
            .toList());
  }
}
