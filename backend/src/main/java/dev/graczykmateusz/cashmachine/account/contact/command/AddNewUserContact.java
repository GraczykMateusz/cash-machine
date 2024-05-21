package dev.graczykmateusz.cashmachine.account.contact.command;

import dev.graczykmateusz.cashmachine.abstraction.command.Command;

public record AddNewUserContact(String userId, int accountNumber, String assignedName)
    implements Command {}
