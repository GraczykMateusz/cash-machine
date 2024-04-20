package dev.graczykmateusz.cashmachine.forex.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyDetailsForexResponseDto;
import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyPriceForexResponseDto;
import java.util.List;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
class CurrencyDetailsForexResponse {

  @JsonProperty("ticker")
  private ExchangeSymbolForexResponse exchangeSymbol;

  @JsonProperty("results")
  private List<CurrencyPriceForexResponse> currencyPrice;

  CurrencyDetailsForexResponseDto toDto() {
    List<CurrencyPriceForexResponseDto> currencyPriceForexResponses =
        currencyPrice.stream().map(CurrencyPriceForexResponse::toDto).toList();
    return new CurrencyDetailsForexResponseDto(
        exchangeSymbol.toConst(), currencyPriceForexResponses);
  }
}
