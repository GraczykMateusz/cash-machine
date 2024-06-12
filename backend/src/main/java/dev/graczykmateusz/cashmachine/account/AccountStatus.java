package dev.graczykmateusz.cashmachine.account;

enum AccountStatus {
  ACTIVE,
  SUSPENDED,
  CLOSED,
  TOO_MANY_LOGIN_ATTEMPTS,
  PASSWORD_EXPIRED
}
