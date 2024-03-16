package dev.graczykmateusz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/test")
class Controller {

  @GetMapping
  String foo() {
    System.out.println("test");
    return "{\"x\": \"x\"}";
  }
}
