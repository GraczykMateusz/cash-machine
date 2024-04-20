package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyDetailsForexResponseDto;
import dev.graczykmateusz.cashmachine.forex.currency.dto.CurrencyDetailsDto;
import dev.graczykmateusz.cashmachine.forex.currency.dto.CurrencyPriceDto;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "currency-details")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter(AccessLevel.PROTECTED)
class CurrencyDetails {

  @Id private String id;
  private String exchangeSymbol;
  private List<CurrencyPrice> currencyPrices;

  CurrencyDetails(String exchangeSymbol, List<CurrencyPrice> currencyPrices) {
    this.exchangeSymbol = exchangeSymbol;
    this.currencyPrices = currencyPrices;
  }

  CurrencyDetailsDto toDto() {
    List<CurrencyPriceDto> currencyPriceDtos =
        currencyPrices.stream().map(CurrencyPrice::toDto).toList();
    return new CurrencyDetailsDto(exchangeSymbol, currencyPriceDtos);
  }

  static CurrencyDetails toDomain(CurrencyDetailsForexResponseDto currencyDetailsForexResponseDto) {
    List<CurrencyPrice> currencyPrices =
        currencyDetailsForexResponseDto.currencyPrices().stream()
            .map(CurrencyPrice::toDomain)
            .toList();
    return new CurrencyDetails(currencyDetailsForexResponseDto.exchangeSymbol(), currencyPrices);
  }
}
