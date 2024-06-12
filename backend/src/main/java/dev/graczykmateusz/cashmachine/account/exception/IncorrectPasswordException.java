package dev.graczykmateusz.cashmachine.account.exception;

import dev.graczykmateusz.cashmachine.abstraction.exception.CacheMachineException;

public class IncorrectPasswordException extends CacheMachineException {

  public IncorrectPasswordException(String message) {
    super(message);
  }
}
