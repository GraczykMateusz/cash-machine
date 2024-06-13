package dev.graczykmateusz.cashmachine.shared.domain;

import java.math.BigDecimal;

public record MoneyBalance(BigDecimal value) {

  public MoneyBalance(Money income, Money outcome) {
    this(income.value().add(outcome.value()));
  }
}
