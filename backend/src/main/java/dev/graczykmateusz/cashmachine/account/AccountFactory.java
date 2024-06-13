package dev.graczykmateusz.cashmachine.account;

import java.time.LocalDateTime;

import dev.graczykmateusz.cashmachine.shared.constant.AccountStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class AccountFactory {

  static Account createNewAccount(
      String firstName,
      String lastName,
      String personalId,
      LocalDateTime createAt,
      Login login,
      Password password) {
    return new Account(
        firstName, lastName, personalId, AccountStatus.ACTIVE, createAt, login, password);
  }
}
