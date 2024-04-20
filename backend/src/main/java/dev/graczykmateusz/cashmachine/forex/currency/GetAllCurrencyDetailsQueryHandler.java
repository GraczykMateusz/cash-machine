package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.abstraction.query.QueryHandler;
import dev.graczykmateusz.cashmachine.api.query.GetAllCurrencyDetails;
import dev.graczykmateusz.cashmachine.forex.currency.dto.AllCurrencyDetailsDto;
import dev.graczykmateusz.cashmachine.forex.currency.dto.CurrencyDetailsDto;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class GetAllCurrencyDetailsQueryHandler
    implements QueryHandler<AllCurrencyDetailsDto, GetAllCurrencyDetails> {

  private final CurrencyDetailsQueryRepository queryRepository;

  @Override
  public AllCurrencyDetailsDto handle(GetAllCurrencyDetails query) {
    List<CurrencyDetails> currencyDetails = queryRepository.findAll();
    List<CurrencyDetailsDto> currencyDetailsDtos =
        currencyDetails.stream().map(CurrencyDetails::toDto).toList();
    return new AllCurrencyDetailsDto(currencyDetailsDtos);
  }
}
