package dev.graczykmateusz.cashmachine.api;

import dev.graczykmateusz.cashmachine.forex.ForexApiRespondedListener;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/forex")
class ForexController {

  private final ForexApiRespondedListener forexHandler;

  @GetMapping
  void get() {
//    forexHandler.getActualForexData(); todo
  }
}
