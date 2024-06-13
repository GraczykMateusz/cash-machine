package dev.graczykmateusz.cashmachine.account.money.query;

import dev.graczykmateusz.cashmachine.abstraction.query.Query;

public record GetMoneyBalance(String accountId) implements Query {}
