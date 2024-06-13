package dev.graczykmateusz.cashmachine.account;

import dev.graczykmateusz.cashmachine.abstraction.command.CommandHandler;
import dev.graczykmateusz.cashmachine.abstraction.query.QueryHandler;
import dev.graczykmateusz.cashmachine.account.command.ChangePassword;
import dev.graczykmateusz.cashmachine.account.command.CreateAccount;
import dev.graczykmateusz.cashmachine.account.command.RemoveAllAccounts;
import dev.graczykmateusz.cashmachine.account.dto.AccountDetailsDto;
import dev.graczykmateusz.cashmachine.account.number.AccountNumberGenerator;
import dev.graczykmateusz.cashmachine.account.password.PasswordEncoder;
import dev.graczykmateusz.cashmachine.account.password.PasswordVerifier;
import dev.graczykmateusz.cashmachine.account.query.GetAccountDetails;
import dev.graczykmateusz.cashmachine.policy.LoginPolicy;
import dev.graczykmateusz.cashmachine.policy.PasswordPolicy;
import java.time.Clock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
class AccountConfiguration {

  @Bean
  CommandHandler<CreateAccount> createAccountCommandHandler(
      AccountRepository repository,
      AccountNumberGenerator accountNumberGenerator,
      PasswordEncoder passwordEncoder,
      Clock clock) {
    LoginPolicy loginPolicy = new LoginPolicy();
    PasswordPolicy passwordPolicy = new PasswordPolicy();
    return new CreateAccountCommandHandler(
        repository, accountNumberGenerator, passwordEncoder, clock, loginPolicy, passwordPolicy);
  }

  @Bean
  CommandHandler<ChangePassword> changePasswordCommandHandler(
      AccountQueryRepository queryRepository,
      PasswordEncoder passwordEncoder,
      PasswordVerifier passwordVerifier) {
    return new ChangePasswordCommandHandler(queryRepository, passwordEncoder, passwordVerifier);
  }

  @Bean
  CommandHandler<RemoveAllAccounts> removeAllAccountsCommandHandler(AccountRepository repository) {
    return new RemoveAllAccountsCommandHandler(repository);
  }

  @Bean
  QueryHandler<AccountDetailsDto, GetAccountDetails> getAccountDetailsQueryHandler(
      AccountQueryRepository queryRepository) {
    return new GetAccountDetailsQueryHandler(queryRepository);
  }
}
