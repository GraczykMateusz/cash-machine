package dev.graczykmateusz.cashmachine.api;

import dev.graczykmateusz.cashmachine.abstraction.query.QueryHandlerExecutor;
import dev.graczykmateusz.cashmachine.forex.currency.query.GetAllCurrencyDetails;
import dev.graczykmateusz.cashmachine.forex.currency.dto.AllCurrencyDetailsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/forex/currency-details")
class CurrencyDetailsController {

  private final QueryHandlerExecutor queryHandlerExecutor;

  @GetMapping("/all")
  AllCurrencyDetailsDto get(GetAllCurrencyDetails query) {
    return (AllCurrencyDetailsDto) queryHandlerExecutor.execute(query);
  }
}
