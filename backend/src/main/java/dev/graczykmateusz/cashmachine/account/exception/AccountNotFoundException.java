package dev.graczykmateusz.cashmachine.account.exception;

import dev.graczykmateusz.cashmachine.abstraction.exception.CacheMachineException;

public class AccountNotFoundException extends CacheMachineException {

  public AccountNotFoundException(String accountId) {
    super("Account with id " + accountId + " not found!");
  }
}
