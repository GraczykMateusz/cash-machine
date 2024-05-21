package dev.graczykmateusz.cashmachine.account.contact.command;

import dev.graczykmateusz.cashmachine.abstraction.command.Command;

public record RemoveUserContact(String id) implements Command {}
