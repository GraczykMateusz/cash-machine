package dev.graczykmateusz.cashmachine.account.number;

import dev.graczykmateusz.cashmachine.account.number.dto.AccountNumberDto;

public interface AccountNumberGenerator {

  AccountNumberDto generate();
}
