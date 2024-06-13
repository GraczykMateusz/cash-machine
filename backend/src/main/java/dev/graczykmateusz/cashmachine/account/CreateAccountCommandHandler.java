package dev.graczykmateusz.cashmachine.account;

import dev.graczykmateusz.cashmachine.abstraction.command.CommandHandler;
import dev.graczykmateusz.cashmachine.account.command.CreateAccount;
import dev.graczykmateusz.cashmachine.account.exception.AccountAlreadyExists;
import dev.graczykmateusz.cashmachine.account.number.AccountNumberGenerator;
import dev.graczykmateusz.cashmachine.account.number.dto.AccountNumberDto;
import dev.graczykmateusz.cashmachine.account.password.PasswordEncoder;
import dev.graczykmateusz.cashmachine.account.password.dto.EncodedPassword;
import dev.graczykmateusz.cashmachine.policy.LoginPolicy;
import dev.graczykmateusz.cashmachine.policy.PasswordPolicy;
import dev.graczykmateusz.cashmachine.shared.domain.Login;
import dev.graczykmateusz.cashmachine.shared.domain.Password;
import java.time.Clock;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class CreateAccountCommandHandler implements CommandHandler<CreateAccount> {

  private final AccountRepository repository;
  private final AccountQueryRepository queryRepository;
  private final AccountNumberGenerator accountNumberGenerator;
  private final PasswordEncoder passwordEncoder;
  private final Clock clock;
  private final LoginPolicy loginPolicy;
  private final PasswordPolicy passwordPolicy;

  @Override
  public void handle(CreateAccount command) {
    if (queryRepository.findById(command.personalId()).isPresent()) {
      throw new AccountAlreadyExists(command.personalId());
    }
    
    Password password = new Password(passwordPolicy, command.password());
    EncodedPassword encodedPassword = passwordEncoder.encodePassword(password);
    AccountNumberDto accountNumber = accountNumberGenerator.generate();
    
    Login login = new Login(loginPolicy, command.login());
    
    Account account =
        AccountFactory.createNewAccount(
            accountNumber,
            command.firstName(),
            command.lastName(),
            command.personalId(),
            LocalDateTime.now(clock),
            login,
            encodedPassword);

    repository.save(account);
  }
}
