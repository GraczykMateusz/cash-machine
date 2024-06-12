package dev.graczykmateusz.cashmachine.account.exception;

import dev.graczykmateusz.cashmachine.abstraction.exception.CashMachineException;

public class AccountNotFoundException extends CashMachineException {

  public AccountNotFoundException(String accountId) {
    super("Account with id " + accountId + " not found!");
  }
}
