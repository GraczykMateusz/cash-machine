package dev.graczykmateusz.cashmachine.forex.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyDetailsForexResponseDto;
import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyPriceForexResponseDto;
import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Data
@AllArgsConstructor
class CurrencyDetailsForexResponse {

  @JsonProperty("ticker")
  String exchangeSymbol;
  
  @JsonProperty("results")
  List<CurrencyPriceForexResponse> currencyPrice;

  CurrencyDetailsForexResponseDto toDto() {
    List<CurrencyPriceForexResponseDto> currencyPriceForexResponses =
        currencyPrice.stream().map(CurrencyPriceForexResponse::toDto).toList();
    return new CurrencyDetailsForexResponseDto(exchangeSymbol, currencyPriceForexResponses);
  }
}
