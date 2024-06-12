package dev.graczykmateusz.cashmachine.account;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

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
  }
  
  void closeAccount() {
    status = AccountStatus.CLOSED;
  }
}
