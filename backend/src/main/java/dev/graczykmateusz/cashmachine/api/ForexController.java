package dev.graczykmateusz.cashmachine.api;

import dev.graczykmateusz.cashmachine.abstraction.query.QueryHandlerExecutor;
import dev.graczykmateusz.cashmachine.abstraction.query.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/forex")
class ForexController {

  private final QueryHandlerExecutor queryHandlerExecutor;
  
  @GetMapping
  Result get(GetCurrencyDetails query) {
    return queryHandlerExecutor.execute(query);
  }
}
