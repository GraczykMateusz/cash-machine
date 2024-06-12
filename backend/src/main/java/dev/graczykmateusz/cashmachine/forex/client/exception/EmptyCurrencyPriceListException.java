package dev.graczykmateusz.cashmachine.forex.client.exception;

import dev.graczykmateusz.cashmachine.abstraction.exception.CashMachineException;

public class EmptyCurrencyPriceListException extends CashMachineException {

  public EmptyCurrencyPriceListException() {
    super("Empty currency price list!");
  }
}
