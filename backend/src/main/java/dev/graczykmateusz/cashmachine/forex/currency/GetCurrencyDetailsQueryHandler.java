package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.abstraction.query.QueryHandler;
import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;
import dev.graczykmateusz.cashmachine.forex.currency.dto.CurrencyDetailsDto;
import dev.graczykmateusz.cashmachine.forex.currency.query.GetCurrencyDetails;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
class GetCurrencyDetailsQueryHandler
    implements QueryHandler<CurrencyDetailsDto, GetCurrencyDetails> {

  private final CurrencyDetailsGrouper grouper;
  private final CurrencyDetailsQueryRepository queryRepository;

  @Override
  public CurrencyDetailsDto handle(GetCurrencyDetails query) {
    List<CurrencyDetails> currencyDetails = queryRepository.findByExchangeSymbol(query.getExchangeSymbol());

    Map<ExchangeSymbol, List<CurrencyDetails>> currencyDetailsForSymbols =
        grouper.groupByExchangeSymbol(currencyDetails);

    CurrencyDetailsDto currencyDetailsDtos =
        CurrencyDetailsMapper.mapToCurrencyDetailsDtos(currencyDetailsForSymbols).stream()
            .filter(
                currencyDetailsDto ->
                    currencyDetailsDto.exchangeSymbol().equals(query.getExchangeSymbol()))
            .findFirst()
            .get();

    return currencyDetailsDtos;
  }
}
