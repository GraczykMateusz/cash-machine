package dev.graczykmateusz.cashmachine.account.contact.command;

import dev.graczykmateusz.cashmachine.abstraction.command.Command;

public record AddNewUserContact(String userId, String accountNumber, String assignedName)
    implements Command {}
