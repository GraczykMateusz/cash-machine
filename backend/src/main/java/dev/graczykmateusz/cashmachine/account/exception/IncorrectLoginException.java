package dev.graczykmateusz.cashmachine.account.exception;

import dev.graczykmateusz.cashmachine.abstraction.exception.CacheMachineException;

public class IncorrectLoginException extends CacheMachineException {

  public IncorrectLoginException(String message) {
    super(message);
  }
}
