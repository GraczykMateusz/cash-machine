package dev.graczykmateusz.cashmachine.account.exception;

import dev.graczykmateusz.cashmachine.abstraction.exception.CashMachineException;

public class IncorrectLoginException extends CashMachineException {

  public IncorrectLoginException(String message) {
    super(message);
  }
}
