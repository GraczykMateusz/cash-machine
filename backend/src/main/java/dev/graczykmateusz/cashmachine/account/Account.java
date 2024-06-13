package dev.graczykmateusz.cashmachine.account;

import dev.graczykmateusz.cashmachine.account.number.dto.AccountNumberDto;
import dev.graczykmateusz.cashmachine.account.password.dto.EncodedPassword;
import dev.graczykmateusz.cashmachine.shared.constant.AccountStatus;
import dev.graczykmateusz.cashmachine.shared.domain.Login;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "accounts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter(AccessLevel.PROTECTED)
class Account {

  @Id private String id;
  private AccountNumberDto accountNumber;
  private String firstName;
  private String lastName;
  private String personalId;

  private AccountStatus status;
  private LocalDateTime createdAt;

  private Login login;
  private EncodedPassword encodedPassword;

  Account(
      AccountNumberDto accountNumber,
      String firstName,
      String lastName,
      String personalId,
      AccountStatus status,
      LocalDateTime createdAt,
      Login login,
      EncodedPassword encodedPassword) {
    this.accountNumber = accountNumber;
    this.firstName = firstName;
    this.lastName = lastName;
    this.status = status;
    this.createdAt = createdAt;
    this.personalId = personalId;
    this.login = login;
    this.encodedPassword = encodedPassword;
  }

  void changePassword(EncodedPassword encodedPassword) {
    this.encodedPassword = encodedPassword;
    //    eventPublisher.publishEvent(new PasswordWasChanged(id));
  }

  void closeAccount() {
    if (status == AccountStatus.CLOSED) {
      return;
    }
    status = AccountStatus.CLOSED;
    //    eventPublisher.publishEvent(new AccountWasClosed(id));
  }
}
