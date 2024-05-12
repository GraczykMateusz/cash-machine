package dev.graczykmateusz.cashmachine.forex.client.exception;

public class EmptyCurrencyPriceListException extends RuntimeException {
    
    public EmptyCurrencyPriceListException() {
        super("Empty currency price list!");
    }
}
