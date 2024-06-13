package dev.graczykmateusz.cashmachine.shared.domain.exception;

import dev.graczykmateusz.cashmachine.abstraction.exception.CashMachineException;

public class IncorrectLoginException extends CashMachineException {

  public IncorrectLoginException(String message) {
    super(message);
  }
}
