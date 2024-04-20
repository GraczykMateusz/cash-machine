package dev.graczykmateusz.cashmachine.forex.currency.command;

import dev.graczykmateusz.cashmachine.abstraction.command.Command;
import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;

public record UpdateDailyCurrencyDetails(ExchangeSymbol exchangeSymbol) implements Command {}
