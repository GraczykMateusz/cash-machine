package dev.graczykmateusz.cashmachine.shared.domain;

import java.math.BigDecimal;

public record Money(BigDecimal value) {

  public Money {
    if (value == null || value.compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("Money value must be positive!");
    }
  }
}
