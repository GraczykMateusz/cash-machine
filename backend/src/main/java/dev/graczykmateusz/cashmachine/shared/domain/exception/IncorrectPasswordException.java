package dev.graczykmateusz.cashmachine.shared.domain.exception;

import dev.graczykmateusz.cashmachine.abstraction.exception.CashMachineException;

public class IncorrectPasswordException extends CashMachineException {

  public IncorrectPasswordException(String message) {
    super(message);
  }
}
