package dev.graczykmateusz.cashmachine.account;

import dev.graczykmateusz.cashmachine.abstraction.command.CommandHandler;
import dev.graczykmateusz.cashmachine.account.command.ChangePassword;
import dev.graczykmateusz.cashmachine.account.exception.AccountNotFoundException;
import dev.graczykmateusz.cashmachine.shared.domain.Password;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class ChangePasswordCommandHandler implements CommandHandler<ChangePassword> {

  private final AccountQueryRepository queryRepository;

  @Override
  public void handle(ChangePassword command) {
    Password password = new Password(command.password());
    Account account =
        queryRepository
            .findById(command.accountId())
            .orElseThrow(() -> new AccountNotFoundException(command.accountId()));
    account.changePassword(password);
  }
}
