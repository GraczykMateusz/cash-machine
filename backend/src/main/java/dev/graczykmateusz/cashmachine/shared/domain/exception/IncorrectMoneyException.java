package dev.graczykmateusz.cashmachine.shared.domain.exception;

import dev.graczykmateusz.cashmachine.abstraction.exception.CashMachineException;

public class IncorrectMoneyException extends CashMachineException {

  public IncorrectMoneyException(String message) {
    super(message);
  }
}
