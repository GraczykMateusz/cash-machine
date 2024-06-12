package dev.graczykmateusz.cashmachine.account;

import java.time.LocalDateTime;

import dev.graczykmateusz.cashmachine.shared.domain.Login;
import dev.graczykmateusz.cashmachine.shared.domain.Password;
import dev.graczykmateusz.cashmachine.shared.constant.AccountStatus;
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
  private String firstName;
  private String lastName;
  private String personalId;

  private AccountStatus status;
  private LocalDateTime createdAt;

  private Login login;
  private Password password;

  Account(
      String firstName,
      String lastName,
      String personalId,
      AccountStatus status,
      LocalDateTime createdAt,
      Login login,
      Password password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.status = status;
    this.createdAt = createdAt;
    this.personalId = personalId;
    this.login = login;
    this.password = password;
  }

  void changePassword(Password password) {
    this.password = password;
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
