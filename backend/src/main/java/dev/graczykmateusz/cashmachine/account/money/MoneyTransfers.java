package dev.graczykmateusz.cashmachine.account.money;

import dev.graczykmateusz.cashmachine.shared.domain.Money;
import java.math.BigDecimal;
import java.util.List;

record MoneyTransfers(List<MoneyTransfer> value) {

  Money sum() {
    return value.stream()
        .map(MoneyTransfer::getAmount)
        .reduce(new Money(BigDecimal.ZERO), Money::add);
  }
}
