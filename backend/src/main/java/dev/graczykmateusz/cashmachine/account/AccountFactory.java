package dev.graczykmateusz.cashmachine.account;

import java.time.LocalDateTime;

import dev.graczykmateusz.cashmachine.account.number.dto.AccountNumberDto;
import dev.graczykmateusz.cashmachine.account.password.dto.EncodedPassword;
import dev.graczykmateusz.cashmachine.shared.constant.AccountStatus;
import dev.graczykmateusz.cashmachine.shared.domain.Login;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class AccountFactory {

  static Account createNewAccount(
      AccountNumberDto accountNumber,
      String firstName,
      String lastName,
      String personalId,
      LocalDateTime createAt,
      Login login,
      EncodedPassword encodedPassword) {
    return new Account(
        accountNumber,
        firstName,
        lastName,
        personalId,
        AccountStatus.ACTIVE,
        createAt,
        login,
        encodedPassword);
  }
}
