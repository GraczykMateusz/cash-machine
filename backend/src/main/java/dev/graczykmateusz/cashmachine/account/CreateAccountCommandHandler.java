package dev.graczykmateusz.cashmachine.account;

import dev.graczykmateusz.cashmachine.abstraction.command.CommandHandler;
import dev.graczykmateusz.cashmachine.account.cmd.CreateAccount;
import java.time.Clock;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class CreateAccountCommandHandler implements CommandHandler<CreateAccount> {

  private final AccountRepository repository;

  private final Clock clock;

  private final LoginPolicy loginPolicy;
  private final PasswordPolicy passwordPolicy;

  @Override
  public void handle(CreateAccount command) {
    Login login = new Login(loginPolicy, command.login());
    Password password = new Password(passwordPolicy, command.password());
    Account account =
        AccountFactory.createNewAccount(
            command.firstName(),
            command.lastName(),
            command.personalId(),
            LocalDateTime.now(clock),
            login,
            password);
    repository.save(account);
  }
}