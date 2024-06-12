package dev.graczykmateusz.cashmachine.account.query;

import dev.graczykmateusz.cashmachine.abstraction.query.Query;

public record GetAccountDetails(String accountId) implements Query {}
