package dev.graczykmateusz.cashmachine.account;

import dev.graczykmateusz.cashmachine.abstraction.command.CommandHandler;
import dev.graczykmateusz.cashmachine.abstraction.query.QueryHandler;
import dev.graczykmateusz.cashmachine.account.cmd.ChangePassword;
import dev.graczykmateusz.cashmachine.account.cmd.CreateAccount;
import dev.graczykmateusz.cashmachine.account.cmd.RemoveAllAccounts;
import dev.graczykmateusz.cashmachine.account.dto.AccountDetailsDto;
import dev.graczykmateusz.cashmachine.account.query.GetAccountDetails;
import java.time.Clock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
class AccountConfiguration {

  @Bean
  CommandHandler<CreateAccount> createAccountCommandHandler(
      AccountRepository repository, Clock clock) {
    LoginPolicy loginPolicy = new LoginPolicy();
    PasswordPolicy passwordPolicy = new PasswordPolicy();
    return new CreateAccountCommandHandler(repository, clock, loginPolicy, passwordPolicy);
  }

  @Bean
  CommandHandler<ChangePassword> changePasswordCommandHandler(
      AccountRepository repository, AccountQueryRepository queryRepository) {
    return new ChangePasswordCommandHandler(repository, queryRepository);
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