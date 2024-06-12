package dev.graczykmateusz.cashmachine.abstraction.exception;

public abstract class CashMachineException extends RuntimeException {

  protected CashMachineException(String message) {
    super(message);
  }

  protected CashMachineException(String message, Throwable cause) {
    super(message, cause);
  }
}
