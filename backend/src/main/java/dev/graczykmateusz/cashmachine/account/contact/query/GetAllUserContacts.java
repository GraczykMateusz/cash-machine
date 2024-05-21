package dev.graczykmateusz.cashmachine.account.contact.query;

import dev.graczykmateusz.cashmachine.abstraction.query.Query;

public record GetAllUserContacts(String userId) implements Query {}
