package dev.graczykmateusz.cashmachine.account;

import java.util.Optional;

interface AccountQueryRepository {

  Optional<Account> findById(String id);
}
