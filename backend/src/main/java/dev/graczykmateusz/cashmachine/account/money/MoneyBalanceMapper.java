package dev.graczykmateusz.cashmachine.account.money;

import dev.graczykmateusz.cashmachine.account.money.dto.MoneyBalanceDto;
import dev.graczykmateusz.cashmachine.shared.domain.MoneyBalance;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class MoneyBalanceMapper {

  static MoneyBalanceDto toDto(MoneyBalance moneyBalance) {
    return new MoneyBalanceDto(moneyBalance.value());
  }
}
