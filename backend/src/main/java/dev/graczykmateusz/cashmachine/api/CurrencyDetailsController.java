package dev.graczykmateusz.cashmachine.api;

import dev.graczykmateusz.cashmachine.abstraction.query.QueryHandlerExecutor;
import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;
import dev.graczykmateusz.cashmachine.forex.currency.dto.AllCurrencyDetailsDto;
import dev.graczykmateusz.cashmachine.forex.currency.dto.CurrencyDetailsDto;
import dev.graczykmateusz.cashmachine.forex.currency.query.GetAllCurrencyDetails;
import dev.graczykmateusz.cashmachine.forex.currency.query.GetCurrencyDetails;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/forex/currency-details")
class CurrencyDetailsController {

  private final QueryHandlerExecutor queryHandlerExecutor;

  @GetMapping("/all")
  AllCurrencyDetailsDto get(GetAllCurrencyDetails query) {
    return (AllCurrencyDetailsDto) queryHandlerExecutor.execute(query);
  }

  @GetMapping("/{exchangeSymbol}")
  CurrencyDetailsDto get(@Valid @NotNull @PathVariable ExchangeSymbol exchangeSymbol) {
    return (CurrencyDetailsDto) queryHandlerExecutor.execute(new GetCurrencyDetails(exchangeSymbol));
  }
}
