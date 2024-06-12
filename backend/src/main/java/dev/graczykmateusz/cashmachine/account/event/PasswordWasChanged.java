package dev.graczykmateusz.cashmachine.account.event;

import dev.graczykmateusz.cashmachine.abstraction.event.DomainEvent;

public record PasswordWasChanged(String accountId) implements DomainEvent {}
