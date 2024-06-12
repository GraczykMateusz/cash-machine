package dev.graczykmateusz.cashmachine.account.money.transfer.exception;

import dev.graczykmateusz.cashmachine.abstraction.exception.CashMachineException;

public class IncorrectMoneyException extends CashMachineException {

  public IncorrectMoneyException(String message) {
    super(message);
  }
}
