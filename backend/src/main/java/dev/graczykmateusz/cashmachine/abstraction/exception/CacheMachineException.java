package dev.graczykmateusz.cashmachine.abstraction.exception;

public abstract class CacheMachineException extends RuntimeException {

  protected CacheMachineException(String message) {
    super(message);
  }

  protected CacheMachineException(String message, Throwable cause) {
    super(message, cause);
  }
}
