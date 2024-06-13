package dev.graczykmateusz.cashmachine.account.money.dto;

import dev.graczykmateusz.cashmachine.abstraction.query.Result;
import java.math.BigDecimal;

public record MoneyBalanceDto(BigDecimal balance) implements Result {}
