package dev.graczykmateusz.cashmachine.account.money.command;

import dev.graczykmateusz.cashmachine.abstraction.command.Command;
import java.math.BigDecimal;

public record ExecuteMoneyTransfer(
    String senderAccountId, String receiverAccountId, BigDecimal amount) implements Command {}
