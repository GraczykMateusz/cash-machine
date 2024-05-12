package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyDetailsForexResponseDto;
import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;
import dev.graczykmateusz.cashmachine.forex.currency.dto.CurrencyDetailsDto;
import dev.graczykmateusz.cashmachine.forex.currency.dto.CurrencyPriceDto;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class CurrencyDetailsMapper {

  static CurrencyDetails fromDto(CurrencyDetailsForexResponseDto dto) {
    List<CurrencyPrice> currencyPrices = mapDtoToCurrencyPrices(dto);
    return new CurrencyDetails(dto.exchangeSymbol(), currencyPrices);
  }

  static List<CurrencyDetailsDto> mapToCurrencyDetailsDtos(
      Map<ExchangeSymbol, List<CurrencyDetails>> currencyDetailsForSymbols) {
    return currencyDetailsForSymbols.entrySet().stream()
        .map(CurrencyDetailsMapper::mapToCurrencyDetailsDto)
        .toList();
  }

  private static List<CurrencyPrice> mapDtoToCurrencyPrices(CurrencyDetailsForexResponseDto dto) {
    return dto.currencyPrices().stream().map(CurrencyPriceMapper::fromDto).toList();
  }

  private static CurrencyDetailsDto mapToCurrencyDetailsDto(
      Map.Entry<ExchangeSymbol, List<CurrencyDetails>> entry) {
    ExchangeSymbol exchangeSymbol = entry.getKey();
    List<CurrencyDetails> currencyDetailsList = entry.getValue();

    List<CurrencyPriceDto> currencyPrices = extractCurrencyPrices(currencyDetailsList);

    return new CurrencyDetailsDto(exchangeSymbol, currencyPrices);
  }

  private static List<CurrencyPriceDto> extractCurrencyPrices(
      List<CurrencyDetails> currencyDetailsList) {
    return currencyDetailsList.stream()
        .flatMap(currencyDetails -> currencyDetails.getCurrencyPrices().stream())
        .sorted(Comparator.comparing(CurrencyPrice::getTimestamp))
        .map(CurrencyPriceMapper::toDto)
        .toList();
  }
}
