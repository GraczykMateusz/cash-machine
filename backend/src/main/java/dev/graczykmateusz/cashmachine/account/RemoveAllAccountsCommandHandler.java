package dev.graczykmateusz.cashmachine.account;

import dev.graczykmateusz.cashmachine.abstraction.command.CommandHandler;
import dev.graczykmateusz.cashmachine.account.command.RemoveAllAccounts;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class RemoveAllAccountsCommandHandler implements CommandHandler<RemoveAllAccounts> {

  private final AccountRepository repository;

  @Override
  public void handle(RemoveAllAccounts command) {
    repository.deleteAll();
  }
}
