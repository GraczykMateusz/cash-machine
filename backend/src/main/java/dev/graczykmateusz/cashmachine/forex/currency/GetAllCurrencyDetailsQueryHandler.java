package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.abstraction.query.QueryHandler;
import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;
import dev.graczykmateusz.cashmachine.forex.currency.dto.AllCurrencyDetailsDto;
import dev.graczykmateusz.cashmachine.forex.currency.dto.CurrencyDetailsDto;
import dev.graczykmateusz.cashmachine.forex.currency.query.GetAllCurrencyDetails;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class GetAllCurrencyDetailsQueryHandler
    implements QueryHandler<AllCurrencyDetailsDto, GetAllCurrencyDetails> {

  private final CurrencyDetailsGrouper grouper;
  private final CurrencyDetailsQueryRepository queryRepository;

  @Override
  public AllCurrencyDetailsDto handle(GetAllCurrencyDetails query) {
    List<CurrencyDetails> currencyDetails = queryRepository.findAll();

    Map<ExchangeSymbol, List<CurrencyDetails>> currencyDetailsForSymbols =
        grouper.groupByExchangeSymbol(currencyDetails);

    List<CurrencyDetailsDto> currencyDetailsDtos =
        CurrencyDetailsMapper.mapToCurrencyDetailsDtos(currencyDetailsForSymbols);

    return new AllCurrencyDetailsDto(currencyDetailsDtos);
  }
}
