package dev.graczykmateusz.cashmachine.account.exception;

import dev.graczykmateusz.cashmachine.abstraction.exception.CashMachineException;

public class AccountAlreadyExists extends CashMachineException {

  public AccountAlreadyExists(String personalId) {
    super("Account with personalId" + personalId + " already exists!");
  }
}
