package dev.graczykmateusz.cashmachine.account;

import dev.graczykmateusz.cashmachine.account.dto.AccountDetailsDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class AccountMapper {

  static AccountDetailsDto toDto(Account account) {
    return new AccountDetailsDto(account.getId(), account.getFirstName());
  }
}
