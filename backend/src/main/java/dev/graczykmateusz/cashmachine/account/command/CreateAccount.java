package dev.graczykmateusz.cashmachine.account.command;

import dev.graczykmateusz.cashmachine.abstraction.command.Command;

public record CreateAccount(
    String firstName, String lastName, String personalId, char[] login, char[] password)
    implements Command {}
